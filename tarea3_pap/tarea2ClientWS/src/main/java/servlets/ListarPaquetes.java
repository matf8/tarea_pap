package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.ControladorPaquetePublish;
import publicadores.ControladorPaquetePublishService;

@WebServlet("/ListarPaquetes")
public class ListarPaquetes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarPaquetes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorPaquetePublishService cpq = new ControladorPaquetePublishService();
		ControladorPaquetePublish port = cpq.getControladorPaquetePublishPort();
		RequestDispatcher rd;
		
		List<String> paquetes = port.listarPaquetes().getItem();
		request.setAttribute("listaPaquetes", paquetes);
		rd = request.getRequestDispatcher("/listarPaquetes.jsp");
		rd.forward(request, response);
		
	}

}
