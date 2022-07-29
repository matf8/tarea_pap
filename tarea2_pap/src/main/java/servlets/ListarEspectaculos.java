package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.PlataformaNoExisteException;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;

@WebServlet("/ListarEspectaculos")
public class ListarEspectaculos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarEspectaculos() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String plat = request.getParameter("plataforma");
		String aux = request.getParameter("aux");
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorEspectaculo icon = fabrica.getIControladorEspectaculo();
		RequestDispatcher rd = null;
		
		if (aux.equals("e")) {
			try {
				ArrayList<String> espectaculos = icon.listarEspectaculos(plat);
				request.setAttribute("espectaculos", espectaculos);
				request.setAttribute("nomPlat", plat);
				rd = request.getRequestDispatcher("/listarEspectaculos.jsp");
			} catch (PlataformaNoExisteException e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/index.jsp");
			}
		} else if(aux.equals("f")) {
			try {
				ArrayList<String> espectaculos = icon.listarEspectaculos(plat);
				request.setAttribute("espectaculos", espectaculos);
				request.setAttribute("nomPlat", plat);
				rd = request.getRequestDispatcher("/listarEspectaculosFuncion.jsp");
			} catch (PlataformaNoExisteException e) {
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/index.jsp");
			}
		}
		rd.forward(request, response);
	}
}
