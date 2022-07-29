package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtFuncion;
import excepciones.FuncionNoValidaException;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;

@WebServlet("/InfoFuncion")
public class InfoFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InfoFuncion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomFuncion = request.getParameter("auxFunc");
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorEspectaculo icon = fabrica.getIControladorEspectaculo();
		RequestDispatcher rd;
		try {
			DtFuncion funcion = icon.seleccionarFuncion(nomFuncion);
			String imagenURL = icon.getImagenFuncion(funcion.getNombre());
			request.setAttribute("imagen", imagenURL);
			request.setAttribute("nombre", funcion.getNombre());
			request.setAttribute("fecha", funcion.getFecha().toString());
			request.setAttribute("hora", funcion.getHoraIni().toString());
			request.setAttribute("fechaReg", funcion.getFechaReg().toString());
			request.setAttribute("invitados", funcion.getInvitados());
			
			rd = request.getRequestDispatcher("/funcionInfo.jsp");
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
			rd = request.getRequestDispatcher("/index.jsp");
		}
		rd.forward(request, response);
	}

}
