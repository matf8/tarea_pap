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
import publicadores.ControladorEspectaculoPublish;
import publicadores.ControladorEspectaculoPublishService;
import publicadores.ControladorPaquetePublish;
import publicadores.ControladorPaquetePublishService;


@WebServlet("/ListarEspectaculosPlataforma")
public class ListarEspectaculosPlataforma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarEspectaculosPlataforma() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorEspectaculoPublishService cpe = new ControladorEspectaculoPublishService();
		ControladorEspectaculoPublish port = cpe.getControladorEspectaculoPublishPort();
		ControladorPaquetePublishService cpq = new ControladorPaquetePublishService();
		ControladorPaquetePublish port2 = cpq.getControladorPaquetePublishPort();

		RequestDispatcher rd;		
		String plataforma = request.getParameter("nombrePlataforma");	
		String paquete = request.getParameter("paquete");		
		
		StringArray lUWB = port2.espectaculosDelPaquete(paquete);
		List<String> espectaculosPaquete = lUWB.getItem();
				
		try {
			StringArray lUWB2 = port.listarEspectaculos(plataforma);
			List<String> lE = lUWB2.getItem();
			for (String k: espectaculosPaquete) {
				if (lE.contains(k))	
					lE.remove(k);				
			}
			request.setAttribute("espectaculos", lE);
			request.setAttribute("plataforma", plataforma);
			request.setAttribute("paquete", paquete);
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}
		rd = request.getRequestDispatcher("/agregarEspecPaqueteCont.jsp");
		rd.forward(request, response);	
	}

}
