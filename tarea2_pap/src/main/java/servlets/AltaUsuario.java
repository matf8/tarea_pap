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
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import excepciones.CorreoExisteException;
import excepciones.UsuarioExisteException;
import interfaces.Fabrica;
import interfaces.IControladorUsuario;

@WebServlet("/AltaUsuario")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "imagenes";

    public AltaUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("up");
		String password2 = request.getParameter("up2");
		RequestDispatcher rd;
		if (!password2.equals(password)) {
			request.setAttribute("mensaje", "Las contraseñas no coinciden.");
			rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);			
		} else {
			String nick = request.getParameter("nickname");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String mail = request.getParameter("mail");
			String fnac = request.getParameter("fnac");
			String bio = request.getParameter("bio");
			String url = request.getParameter("url");
			String desc = request.getParameter("desc");
			String boton = request.getParameter("aux");
			LocalDate f = LocalDate.parse(fnac);
			
			String appPath = request.getServletContext().getRealPath("");
			String savePath = appPath + File.separator + UPLOAD_DIRECTORY;		
			File fileSaveDir = new File(savePath);
			
			if (!fileSaveDir.exists()) {
		            fileSaveDir.mkdir();
		    }
		        
			byte[] imagen = null;		
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
						
			Fabrica fabrica = Fabrica.getInstancia();
			IControladorUsuario icon = fabrica.getIControladorUsuario();
			
			try {			
				icon.chequearDisponibilidadNickname(nick);	
				icon.chequearDisponibilidadCorreo(mail);	
				if ("artista".equals(boton)) {
					DtArtista dta = new DtArtista(nick, nombre, apellido, f, mail, password, desc, url, bio);
					icon.ingresarDatosArtista(dta, imagen);
					icon.altaUsuario();
					request.setAttribute("mensaje", "Te has registrado correctamente artista " + nick + " bienvenido a Coronatickets.uy!!!");
				} else {
					DtEspectador dtu = new DtEspectador(nick, nombre, apellido, f, mail, password);
					icon.ingresarDatosEspectador(dtu, imagen);
					icon.altaUsuario();
					request.setAttribute("mensaje", "Te has registrado correctamente espectador " + nick + " bienvenido a Coronatickets.uy!!!");
				}
			} catch(Exception j) {
				request.setAttribute("mensaje", j.getMessage());
			}
			rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);	
		}
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
}
