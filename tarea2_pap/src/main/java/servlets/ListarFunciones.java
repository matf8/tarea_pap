package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtEspectaculoCompleto;
import excepciones.EspectaculoNoValidoException;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;

@WebServlet("/ListarFunciones")
public class ListarFunciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarFunciones() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomEspectaculo = request.getParameter("aux");
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorEspectaculo icon = fabrica.getIControladorEspectaculo();
		try {
			DtEspectaculoCompleto espectaculo = icon.seleccionarEspectaculo(nomEspectaculo);
			request.setAttribute("funciones", espectaculo.getFuncionesAsociadas());
			request.setAttribute("espectaculo", nomEspectaculo);
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/listarFunciones.jsp");
		rd.forward(request, response);
	}

}