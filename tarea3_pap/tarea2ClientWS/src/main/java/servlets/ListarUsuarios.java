package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import net.java.dev.jaxb.array.StringArray;

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
		ControladorUsuarioPublishService cps = new ControladorUsuarioPublishService();
		ControladorUsuarioPublish port = cps.getControladorUsuarioPublishPort();	
		
		StringArray lUWB = port.listarUsuarios();
		List<String> lU = lUWB.getItem();		
		
		request.setAttribute("listaUsuarios", lU);		
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/consultaUsuario.jsp");
		rd.forward(request, response);
	}

}
