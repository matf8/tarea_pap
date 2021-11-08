package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.ControladorEspectaculoPublish;
import publicadores.ControladorEspectaculoPublishService;

@WebServlet("/InfoEspectaculo")
public class InfoEspectaculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InfoEspectaculo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomEspectaculo = request.getParameter("auxEspectaculo");
		
			try {
				publicadores.DtEspectaculoCompleto aux = seleccionarEspectaculo(nomEspectaculo);
				request.setAttribute("nombre", aux.getNombre());
				request.setAttribute("url", aux.getURL());
				request.setAttribute("desc", aux.getDescripcion());
				request.setAttribute("dur", aux.getDuracion());
				request.setAttribute("fReg", aux.getFechaRegString());
				request.setAttribute("costo", aux.getCosto());
				request.setAttribute("funciones", aux.getFuncionesAsociadas());
				request.setAttribute("paquetes", aux.getPaquetesAsociados());	
				request.setAttribute("imagen", aux.getImagen());
				String org = aux.getOrganizador();
				request.setAttribute("org", org);
			} catch (Exception e) {
				request.setAttribute("mensaje", e.getMessage());
			}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/espectaculoInfo.jsp");
		rd.forward(request, response);
	}
	
	public publicadores.DtEspectaculoCompleto seleccionarEspectaculo( String espectaculo) throws Exception{
		ControladorEspectaculoPublishService cps = new ControladorEspectaculoPublishService();
		ControladorEspectaculoPublish port = cps.getControladorEspectaculoPublishPort();
		publicadores.DtEspectaculoCompleto aux = port.getDT(espectaculo);
		return aux;
		
		
	}
}
