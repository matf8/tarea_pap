package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorPaquete;


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
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorEspectaculo iconE = fabrica.getIControladorEspectaculo();
		IControladorPaquete iconP = fabrica.getIControladorPaquete();

		RequestDispatcher rd;		
		String plataforma = request.getParameter("nombrePlataforma");	
		String paquete = request.getParameter("paquete");		
		
		List<String> espectaculosPaquete = iconP.espectaculosDelPaquete(paquete);
				
		try {
			List<String> lE = iconE.listarEspectaculos(plataforma);	
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
