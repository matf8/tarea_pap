package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.Fabrica;
import interfaces.IControladorUsuario;

@WebServlet("/DejarSeguirUsuario")
public class DejarSeguirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DejarSeguirUsuario() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("nick");		
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorUsuario icon = fabrica.getIControladorUsuario();
		RequestDispatcher rd;
		
		HttpSession sesion = request.getSession();
		String nickLogeado = (String) sesion.getAttribute("nick");
		try {
			//if (nickLogeado.equals(icon.whoami().getNickName()))
			icon.dejarSeguirUsuario(nick);
			request.setAttribute("mensaje", nickLogeado + " No sigue más al usuario  " + nick + ".");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mensaje", e.getMessage());
		}	
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
}