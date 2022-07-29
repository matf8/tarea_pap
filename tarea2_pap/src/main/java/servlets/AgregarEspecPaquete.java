package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.PlataformaNoValidaException;
import interfaces.Fabrica;
import interfaces.IControladorPaquete;

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
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorPaquete icon = fabrica.getIControladorPaquete();
		RequestDispatcher rd;		
		String plataforma = request.getParameter("plataforma");
		String espectaculo = request.getParameter("espectaculo");
		String paquete = request.getParameter("paquete");
		
		try {
			List<String> tmp = icon.seleccionarPlataforma(plataforma, paquete);
			icon.agregarEspectaculoAPaquete(espectaculo);		
			request.setAttribute("mensaje", "Espectaculo agregado");
		} catch (PlataformaNoValidaException e) {
			request.setAttribute("mensaje", e.getMessage());
		}		
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);			
	}
	
}