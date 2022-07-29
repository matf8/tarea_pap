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

@WebServlet("/CanjearPaquete")
public class CanjearPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CanjearPaquete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String funcion = request.getParameter("nombreFuncion_Paquetes");	
		String paqueteParaCanjear = request.getParameter("paqueteElegido");
		String espectaculo = request.getParameter("espectaculo_Paquetes");
		
		HttpSession sesion = request.getSession();
		String nick = (String) sesion.getAttribute("nick"); 
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorFuncion icon = fabrica.getIControladorFuncion();		
		RequestDispatcher rd;	
		
		if (paqueteParaCanjear != null) {				
			try {
				icon.seleccionarEspectaculo(espectaculo);
				icon.altaRegistroPaquete(nick, funcion, espectaculo, paqueteParaCanjear);
				request.setAttribute("mensaje", "Registro comprado con descuento por paquete exitosamente");	
			} catch (Exception e) {			
				request.setAttribute("mensaje", e.getMessage());
			}	
		} else request.setAttribute("mensaje", "Debe elegir un paquete.");

		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);	
	}

}
