package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import detect.UAgentInfo;

@WebServlet("/InicioSesion")
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InicioSesion() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickMail = request.getParameter("nickMail");
		String password = request.getParameter("pass");
				
		RequestDispatcher rd;	
		ControladorUsuarioPublishService cps = new ControladorUsuarioPublishService();
		ControladorUsuarioPublish port = cps.getControladorUsuarioPublishPort();
		
		try {
			String tipo = port.iniciarSesion(nickMail,password);	
			if (tipo.equals("artista") && isRequestComingFromAMobileDevice(request)) {
				port.cerrarSesion();
				request.setAttribute("mensaje", "Debe ser espectador");				
			} else {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("tipoSesion", tipo);
				String nick = port.whoami().getNickName();
				sesion.setAttribute("nick", nick);
				String mail = port.whoami().getMail();
				sesion.setAttribute("mail", mail);					
				sesion.setAttribute("imagenPerfil", port.getImagenUsuario(nick));
				request.setAttribute("mensaje", "Te has logeado correctamente");				
			}
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}	
		
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	
	private boolean isRequestComingFromAMobileDevice(final HttpServletRequest request){

	    final String userAgent = request.getHeader("User-Agent");
	    final String httpAccept = request.getHeader("Accept");

	    final UAgentInfo detector = new UAgentInfo(userAgent, httpAccept);

	    return detector.detectMobileQuick();
	}
}
