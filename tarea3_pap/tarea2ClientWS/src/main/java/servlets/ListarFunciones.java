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

@WebServlet("/ListarFunciones")
public class ListarFunciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarFunciones() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomEspectaculo = request.getParameter("aux");
		try {
			publicadores.DtEspectaculoCompleto espectaculo = seleccionarEspectaculo(nomEspectaculo);
			request.setAttribute("funciones", espectaculo.getFuncionesAsociadas());
			request.setAttribute("espectaculo", nomEspectaculo);
		} catch (Exception e) {
				request.setAttribute("mensaje", e.getMessage());
			}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/listarFunciones.jsp");
		rd.forward(request, response);
	}
	
	public publicadores.DtEspectaculoCompleto seleccionarEspectaculo( String espectaculo) throws Exception{
		ControladorEspectaculoPublishService cps = new ControladorEspectaculoPublishService();
		ControladorEspectaculoPublish port = cps.getControladorEspectaculoPublishPort();
		publicadores.DtEspectaculoCompleto aux = port.getDT(espectaculo);
		return aux;
	}
}