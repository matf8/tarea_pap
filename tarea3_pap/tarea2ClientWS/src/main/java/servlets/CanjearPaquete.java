package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicadores.ControladorFuncionPublish;
import publicadores.ControladorFuncionPublishService;

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
		
		ControladorFuncionPublishService cps = new ControladorFuncionPublishService();
		ControladorFuncionPublish port = cps.getControladorFuncionPublishPort();
		
		RequestDispatcher rd;	
		
		if (paqueteParaCanjear != null) {				
			try {
				port.seleccionarEspectaculo(espectaculo);
				port.altaRegistroPaquete(nick, funcion, espectaculo, paqueteParaCanjear);
				request.setAttribute("mensaje", "Registro comprado con descuento por paquete exitosamente");	
			} catch (Exception e) {			
				request.setAttribute("mensaje", e.getMessage());
			}	
		} else request.setAttribute("mensaje", "Debe elegir un paquete.");

		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);	
	}

}
