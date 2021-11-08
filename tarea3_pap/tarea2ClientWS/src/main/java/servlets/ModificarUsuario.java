package servlets;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.io.FileUtils;

import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;

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
		RequestDispatcher rd;
		ControladorUsuarioPublishService cps = new ControladorUsuarioPublishService();
		ControladorUsuarioPublish port = cps.getControladorUsuarioPublishPort();
		
		String tipo = (String) sesion.getAttribute("tipoSesion");
		String nickname = request.getParameter("nickname");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String fnacJsp = request.getParameter("fnac");		
		String mail = request.getParameter("mail");		
		String p = null;
		Date fnacDate;
		XMLGregorianCalendar fnac = null;
		
		try {			
			fnacDate = new SimpleDateFormat("yyyy-MM-dd").parse(fnacJsp);
			System.out.println(fnacDate);	
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(fnacDate);
			fnac = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
				
			String appPath = request.getServletContext().getRealPath("");
			String savePath = appPath + File.separator + UPLOAD_DIRECTORY;		
			File fileSaveDir = new File(savePath);
		
			if (!fileSaveDir.exists()) 
		            fileSaveDir.mkdir();
		   
	        
			byte[] imagen = new byte[0];	
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
	        				
			if (tipo.equals("artista")) {
				String desc = (String) request.getParameter("desc");
				String url = (String) request.getParameter("url");
				String bio = (String) request.getParameter("bio");					
				publicadores.DtArtista dta = new publicadores.DtArtista();	
				dta.setNickName(nickname);
				dta.setNombre(nombre);
				dta.setApellido(apellido);
				dta.setMail(mail);
				dta.setFnac(fnac);
				dta.setPasswd(p);
				dta.setDescripcion(desc);
				dta.setUrl(url);
				dta.setBiografia(bio);	
				port.modificarUsuario(dta, imagen);
			} else {
				publicadores.DtEspectador dte = new publicadores.DtEspectador();
				dte.setNickName(nickname);
				dte.setNombre(nombre);
				dte.setApellido(apellido);
				dte.setMail(mail);
				dte.setFnac(fnac);
				port.modificarUsuario(dte, imagen);	
			}
			sesion.setAttribute("imagenPerfil", port.getImagenUsuario(nickname));
			request.setAttribute("mensaje", "Se ha modificado el usuario correctamente ");	
		
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}	
			
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);		
	}

}
