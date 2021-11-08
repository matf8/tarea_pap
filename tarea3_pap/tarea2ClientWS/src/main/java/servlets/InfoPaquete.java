package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.ControladorPaquetePublish;
import publicadores.ControladorPaquetePublishService;
import publicadores.DtPaquete;

@WebServlet("/InfoPaquete")
public class InfoPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InfoPaquete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomPaquete = request.getParameter("auxPaq");
		ControladorPaquetePublishService cps = new ControladorPaquetePublishService();
		ControladorPaquetePublish port = cps.getControladorPaquetePublishPort();
		RequestDispatcher rd;
		try {
			DtPaquete paquete = port.seleccionarPaquete(nomPaquete);
			request.setAttribute("nombre", paquete.getNombre());
			request.setAttribute("descripcion", paquete.getDescripcion());
			request.setAttribute("fechaInicio", paquete.getFechaInicio().toString());
			request.setAttribute("fechaFin", paquete.getFechaFin().toString());
			request.setAttribute("fechaReg", paquete.getFechaRegistro().toString());
			request.setAttribute("espectaculos", paquete.getEspectaculos());
			request.setAttribute("imagen", port.getImagenPaquete(paquete.getNombre()));
			rd = request.getRequestDispatcher("/paqueteInfo.jsp");
		} catch (Exception e) {
			request.setAttribute("mensaje", "El paquete no se encuentra en el sistema");
			rd = request.getRequestDispatcher("/index.jsp");
		}
		rd.forward(request, response);
	}
}