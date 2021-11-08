package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.java.dev.jaxb.array.StringArray;
import publicadores.ControladorPaquetePublish;
import publicadores.ControladorPaquetePublishService;

@WebServlet("/AgregarEspecPaquete")
public class AgregarEspecPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AgregarEspecPaquete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorPaquetePublishService cpq = new ControladorPaquetePublishService();
		ControladorPaquetePublish port = cpq.getControladorPaquetePublishPort();
		RequestDispatcher rd;		
		String plataforma = request.getParameter("plataforma");
		String espectaculo = request.getParameter("espectaculo");
		String paquete = request.getParameter("paquete");
		
		try {
			StringArray lUWB = port.seleccionarPlataforma(plataforma, paquete);
			List<String> tmp = lUWB.getItem();
			port.agregarEspectaculoAPaquete(espectaculo);		
			request.setAttribute("mensaje", "Espectaculo agregado");
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}		
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);			
	}
	
}