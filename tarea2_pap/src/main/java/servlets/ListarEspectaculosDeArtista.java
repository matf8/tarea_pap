package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.Fabrica;
import interfaces.IControladorFuncion;
import interfaces.IControladorUsuario;

@WebServlet("/ListarEspectaculosDeArtista")
public class ListarEspectaculosDeArtista extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarEspectaculosDeArtista() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String nickname = (String)sesion.getAttribute("nick");
		
		Fabrica fabrica = Fabrica.getInstancia();
		
		IControladorUsuario iconU = fabrica.getIControladorUsuario();		
		IControladorFuncion icon = fabrica.getIControladorFuncion();
		
		List<String> todosA = iconU.listarArtista();
			
		request.setAttribute("artistas", todosA);
		
		try {
			ArrayList<String> espectaculos = icon.listarEspectaculosPorArtista(nickname);
			request.setAttribute("espectaculos", espectaculos);
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/altaFuncion.jsp");
		rd.forward(request, response);
	}

}

