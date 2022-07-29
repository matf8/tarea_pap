package servlets;

import java.io.IOException;
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

@WebServlet("/DatosFuncion")
public class DatosFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DatosFuncion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String funcion = request.getParameter("funcionElegida");
		String espectaculo = request.getParameter("espectaculo");
		HttpSession sesion = request.getSession();
		String nick = (String) sesion.getAttribute("nick"); 

		Fabrica fabrica = Fabrica.getInstancia();
		IControladorFuncion icon = fabrica.getIControladorFuncion();
		IControladorUsuario iconU = fabrica.getIControladorUsuario();		
		
		DtEspectador dte = (DtEspectador) iconU.seleccionarUsuario(nick); 		
		
		RequestDispatcher rd;				
				
		try {
			List<DtRegistroCompleto> reg = icon.listarRegistros(nick);
			icon.seleccionarEspectaculo(espectaculo);
			List<String> paquetes = icon.listarPaquetes(nick);		
						
			icon.seleccionarEspectaculo(espectaculo);
			DtFuncion dtf = icon.seleccionarFuncion(funcion);
			request.setAttribute("nombreF", dtf.getNombre());
			request.setAttribute("fecha", dtf.getFecha().toString());
			request.setAttribute("hora", dtf.getHoraIni().toString());	
			request.setAttribute("registros", reg);	
			request.setAttribute("paquetes", paquetes);	
			request.setAttribute("espectaculo", espectaculo);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mensaje", e.getMessage());
		}		
		rd = request.getRequestDispatcher("/datosFuncion.jsp");
		rd.forward(request, response);	
		}	
	
}
