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

@WebServlet("/SeguirUsuario")
public class SeguirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SeguirUsuario() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();	
		ControladorUsuarioPublishService cps = new ControladorUsuarioPublishService();
		ControladorUsuarioPublish port = cps.getControladorUsuarioPublishPort();
		RequestDispatcher rd;
				
		String user = (String) sesion.getAttribute("nick");
		String nick = request.getParameter("nick");			

		try {
			if (!nick.equals(user))	{				
				port.seguirUsuario(nick);
			}
			else throw new Exception ("No te puedes seguir a ti mismo.");
			request.setAttribute("mensaje", "Usuario  " + nick + " seguido correctamente.");
		}catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}	
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
}