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
import publicadores.Exception_Exception;

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
		RequestDispatcher rd;
		
			try {
				publicadores.DtFuncion funcion = seleccionarFuncion(nomFuncion);
				try {
					String imagenURL = getImagenFuncion(funcion.getNombre());
					request.setAttribute("imagen", imagenURL);
				} catch (Exception e) {
					request.setAttribute("imagen", null);
				}
				request.setAttribute("nombre", funcion.getNombre());
				request.setAttribute("fecha", funcion.getFecha().toString());
				request.setAttribute("hora", funcion.getHoraIni().toString());
				request.setAttribute("fechaReg", funcion.getFechaReg().toString());
				request.setAttribute("invitados", funcion.getArtistasInvitados());
				
				rd = request.getRequestDispatcher("/funcionInfo.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("mensaje", e.getMessage());
				rd = request.getRequestDispatcher("/index.jsp");
			}
		rd.forward(request, response);
	}
	
	private publicadores.DtFuncion seleccionarFuncion(String nomFuncion) throws Exception_Exception {
		ControladorEspectaculoPublishService cps = new ControladorEspectaculoPublishService();
		ControladorEspectaculoPublish port = cps.getControladorEspectaculoPublishPort();
		publicadores.DtFuncion aux = port.seleccionarFuncion(nomFuncion);
		return aux;
	}
	
	private String getImagenFuncion(String nomFuncion) throws Exception_Exception {
		ControladorEspectaculoPublishService cps = new ControladorEspectaculoPublishService();
		ControladorEspectaculoPublish port = cps.getControladorEspectaculoPublishPort();
		String aux = port.getImagenFuncion(nomFuncion);
		return aux;
	}
}
