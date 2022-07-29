package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datatypes.DtEspectador;
import datatypes.DtFuncion;
import datatypes.DtRegistroCompleto;
import interfaces.Fabrica;
import interfaces.IControladorFuncion;
import interfaces.IControladorUsuario;

@WebServlet("/RegistroFuncion")
public class RegistroFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegistroFuncion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String funcion = request.getParameter("nombreF");	
		String espectaculo = request.getParameter("espectaculo");
		
		HttpSession sesion = request.getSession();
		String nick = (String) sesion.getAttribute("nick"); 

		Fabrica fabrica = Fabrica.getInstancia();
		IControladorFuncion icon = fabrica.getIControladorFuncion();		
		RequestDispatcher rd;
		
		List<Integer> rIndS = new ArrayList<>();			
	
		try {
			icon.seleccionarEspectaculo(espectaculo);
			DtFuncion dtf = icon.seleccionarFuncion(funcion);	
			List<DtRegistroCompleto> reg = icon.listarRegistros(nick);	
			icon.altaRegistro(rIndS);
			request.setAttribute("mensaje", "Registro creado exitosamente");
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}		
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);	
	}

}
