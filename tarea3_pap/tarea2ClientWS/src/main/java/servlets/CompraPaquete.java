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

import net.java.dev.jaxb.array.StringArray;
import publicadores.ControladorPaquetePublish;
import publicadores.ControladorPaquetePublishService;

@WebServlet("/CompraPaquete")
public class CompraPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CompraPaquete() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paquete = request.getParameter("selectPaquete");
		HttpSession sesion = request.getSession();
		String nickEspectador = (String) sesion.getAttribute("nick");
		
		ControladorPaquetePublishService cpq = new ControladorPaquetePublishService();
		ControladorPaquetePublish port = cpq.getControladorPaquetePublishPort();
		RequestDispatcher rd;
		
		try {
			port.comprarPaquete(paquete, nickEspectador);
			request.setAttribute("mensaje", "El Paquete fue comprado correctamente.");
			rd = request.getRequestDispatcher("/index.jsp");
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
			StringArray lP = port.listarPaquetesVigentes();
			List<String> p = lP.getItem();
			request.setAttribute("listaPaquetesVigentes", p);
			rd = request.getRequestDispatcher("/comprarPaquete.jsp");
		}	
		
		rd.forward(request, response);
	}
}