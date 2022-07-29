package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;
import interfaces.IControladorPlataforma;

@WebServlet("/ListarPlataformas")
public class ListarPlataformas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarPlataformas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorPlataforma icon = fabrica.getIControladorPlataforma();
		RequestDispatcher rd;
		String paquete = request.getParameter("nombrePaquete");		
		
		List<String> plataformas = icon.listaPlataformas();		
		request.setAttribute("plataformas", plataformas);
		request.setAttribute("nombrePaqueteCont", paquete);
		rd = request.getRequestDispatcher("/agregarEspecPaquete.jsp");
		rd.forward(request, response);		
	}

}