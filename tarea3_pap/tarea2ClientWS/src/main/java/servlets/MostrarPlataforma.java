package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.ControladorEspectaculoPublish;
import publicadores.ControladorEspectaculoPublishService;

@WebServlet("/MostrarPlataforma")
public class MostrarPlataforma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MostrarPlataforma() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreP = request.getParameter("nombrePlataforma");	
		ControladorEspectaculoPublishService cpe = new ControladorEspectaculoPublishService();
		ControladorEspectaculoPublish port = cpe.getControladorEspectaculoPublishPort();
		RequestDispatcher rd;	
		try {
			List<String> espectaculos = port.listarEspectaculos(nombreP).getItem();
			request.setAttribute("espectaculos", espectaculos);
			rd = request.getRequestDispatcher("/mostrarEspectaculo.jsp");
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
			rd = request.getRequestDispatcher("/index.jsp");

		}		
		rd.forward(request, response);
	}
	
}
