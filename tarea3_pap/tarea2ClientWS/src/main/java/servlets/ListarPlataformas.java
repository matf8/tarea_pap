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
import publicadores.ControladorPlataformaPublish;
import publicadores.ControladorPlataformaPublishService;

@WebServlet("/ListarPlataformas")
public class ListarPlataformas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarPlataformas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorPlataformaPublishService cpe = new ControladorPlataformaPublishService();
		ControladorPlataformaPublish port = cpe.getControladorPlataformaPublishPort();
		RequestDispatcher rd;
		String paquete = request.getParameter("nombrePaquete");		
		
		StringArray lUWB = port.listaPlataformas();
		List<String> plataformas = lUWB.getItem();
		request.setAttribute("plataformas", plataformas);
		request.setAttribute("nombrePaqueteCont", paquete);
		rd = request.getRequestDispatcher("/agregarEspecPaquete.jsp");
		rd.forward(request, response);		
	}

}