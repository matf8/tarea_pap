package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtEspectaculoCompleto;
import excepciones.EspectaculoNoValidoException;
import interfaces.Fabrica;
import interfaces.IControladorFuncion;

@WebServlet("/MostrarFunciones")
public class MostrarFunciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MostrarFunciones() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomEspectaculo = request.getParameter("espectaculoElegido");
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorFuncion icon = fabrica.getIControladorFuncion();
		List<String> lF = new ArrayList<>();
		try {
			icon.seleccionarEspectaculo(nomEspectaculo);
			lF = icon.listarFuncionesVigentes();
			request.setAttribute("funciones", lF);
			request.setAttribute("espectaculo", nomEspectaculo);
		} catch (EspectaculoNoValidoException e) {
			request.setAttribute("mensaje", e.getMessage());
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/mostrarFunciones.jsp");
		rd.forward(request, response);
	}

}