package servlets;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import interfaces.Fabrica;
import interfaces.IControladorUsuario;

@WebServlet("/ModificarUsuario")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "imagenes";

       
    public ModificarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String tipo = (String) sesion.getAttribute("tipoSesion");
		String nickname = request.getParameter("nickname");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String fnac = request.getParameter("fnac");		
		String mail = request.getParameter("mail");		
		LocalDate f = LocalDate.parse(fnac);
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorUsuario icon = fabrica.getIControladorUsuario();
		RequestDispatcher rd;
		
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + UPLOAD_DIRECTORY;		
		File fileSaveDir = new File(savePath);
		
		if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdir();
	    }
	        
		byte[] imagen = null;	
		String error = null;
		try {
	        for (Part part : request.getParts()) {
	            String fileName = extractFileName(part);
	            // refines the fileName in case it is an absolute path
	            fileName = new File(fileName).getName();         
	            if (fileName != null && !"".equals(fileName)) {
	            	part.write(savePath + File.separator + fileName);   
	            	File img = new File(savePath + File.separator + fileName);
	            	imagen = FileUtils.readFileToByteArray(img);	            
	            }            
	        }    
		} catch (Exception g) {
			error = "Archivo no soportado";			
		}
		try {		
			if(tipo.equals("artista")) {
				String desc = (String) request.getParameter("desc");
				String url = (String) request.getParameter("url");
				String bio = (String) request.getParameter("bio");			
				DtArtista dta = new DtArtista(nickname, nombre, apellido, f, mail, null, desc, url, bio);
				icon.modificarUsuario(dta, imagen);
			}else {
				DtEspectador dtu = new DtEspectador(nickname, nombre, apellido, f, mail, null);
				icon.modificarUsuario(dtu, imagen);
			}	
		} catch (Exception k) {
			error = "Archivo no soportado";	
		}
		
		try {
			sesion.setAttribute("imagenPerfil", icon.getImagenUsuario(nickname));
		} catch (Exception e) {
			error = e.getMessage();

		}			
		String env = "Se ha modificado el usuario correctamente ";		
		if (error != null) 
			env = error;				
			
		request.setAttribute("mensaje", env);
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
	}

}
