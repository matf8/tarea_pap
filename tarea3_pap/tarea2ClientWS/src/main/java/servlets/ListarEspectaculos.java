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

@WebServlet("/ListarEspectaculos")
public class ListarEspectaculos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarEspectaculos() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String plat = request.getParameter("plataforma");
		String aux = request.getParameter("aux");
		RequestDispatcher rd = null;
			if (aux.equals("e")) {
				try {
					List<String> espectaculos = listarEspectaculos(plat);
					request.setAttribute("espectaculos", espectaculos);
					request.setAttribute("nomPlat", plat);
					rd = request.getRequestDispatcher("/listarEspectaculos.jsp");
				} catch (Exception e) {
					request.setAttribute("mensaje", e.getMessage());
					rd = request.getRequestDispatcher("/index.jsp");
				}
			} else if(aux.equals("f")) {
				try {
					List<String> espectaculos = listarEspectaculos(plat);
					request.setAttribute("espectaculos", espectaculos);
					request.setAttribute("nomPlat", plat);
					rd = request.getRequestDispatcher("/listarEspectaculosFuncion.jsp");
				} catch (publicadores.PlataformaNoExisteException_Exception e) {
					request.setAttribute("mensaje", e.getMessage());
					rd = request.getRequestDispatcher("/index.jsp");
				} catch (Exception e) {
					request.setAttribute("mensaje", e.getMessage());
					rd = request.getRequestDispatcher("/index.jsp");
				}
			}
			rd.forward(request, response);
		}		
	
	public List<String> listarEspectaculos( String plat) throws Exception{
		ControladorEspectaculoPublishService cps = new ControladorEspectaculoPublishService();
		ControladorEspectaculoPublish port = cps.getControladorEspectaculoPublishPort();
		List<String> ret=null;
		StringArray aux = port.listarEspectaculos (plat);
		ret=aux.getItem();
		return ret;		
	}
}


