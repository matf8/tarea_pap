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

@WebServlet("/CerrarSesion")
public class CerrarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CerrarSesion() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		RequestDispatcher rd;
		ControladorUsuarioPublishService cps = new ControladorUsuarioPublishService();
		ControladorUsuarioPublish port = cps.getControladorUsuarioPublishPort();
		
		try {
			port.cerrarSesion();
			HttpSession sesion = request.getSession();
			sesion.removeAttribute("tipoSesion");
			sesion.removeAttribute("nick");
			sesion.removeAttribute("imagenPerfil");
			request.setAttribute("mensaje", "Has salido correctamente.");
		} catch (Exception e) {			
			request.setAttribute("mensaje", e.getMessage());
		}		
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
			
	}	

}