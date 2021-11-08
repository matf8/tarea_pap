package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicadores.ControladorFuncionPublish;
import publicadores.ControladorFuncionPublishService;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;

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
		
		ControladorFuncionPublishService cps = new ControladorFuncionPublishService();
		ControladorFuncionPublish portF = cps.getControladorFuncionPublishPort();
		ControladorUsuarioPublishService cpu = new ControladorUsuarioPublishService();
		ControladorUsuarioPublish portU = cpu.getControladorUsuarioPublishPort();
		
		List<String> todosA = portU.listarArtista().getItem();
			
		request.setAttribute("artistas", todosA);
		
		try {
			List<String> espectaculos = portF.listarEspectaculosPorArtista(nickname).getItem();
			request.setAttribute("espectaculos", espectaculos);
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/altaFuncion.jsp");
		rd.forward(request, response);
	}

}

