package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.Fabrica;
import interfaces.IControladorUsuario;

@WebServlet("/ListarUsuarios")
public class ListarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarUsuarios() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
	//String nick = (String) sesion.getAttribute("nick");		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorUsuario icon = fabrica.getIControladorUsuario();
		
		ArrayList<String> lU = icon.listarUsuarios();
		
		request.setAttribute("listaUsuarios", lU);		
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/consultaUsuario.jsp");
		rd.forward(request, response);
	}

}
