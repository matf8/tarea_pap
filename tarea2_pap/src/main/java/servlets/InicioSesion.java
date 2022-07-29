package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.UsuarioExisteException;
import interfaces.Fabrica;
import interfaces.IControladorUsuario;

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
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorUsuario icon = fabrica.getIControladorUsuario();
		RequestDispatcher rd;
		
		try {
			String tipo = icon.iniciarSesion(nickMail, password);
			HttpSession sesion = request.getSession();
			sesion.setAttribute("tipoSesion", tipo);
			String nick = icon.whoami().getNickName();
			sesion.setAttribute("nick", nick);
			String mail = icon.whoami().getMail();
			sesion.setAttribute("mail", mail);	
			sesion.setAttribute("imagenPerfil", icon.getImagenUsuario(nick));
			request.setAttribute("mensaje", "Te has logeado correctamente");
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}
		
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	

}
