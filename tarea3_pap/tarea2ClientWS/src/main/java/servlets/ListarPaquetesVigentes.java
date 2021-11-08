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
import publicadores.ControladorPaquetePublish;
import publicadores.ControladorPaquetePublishService;

@WebServlet("/ListarPaquetesVigentes")
public class ListarPaquetesVigentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarPaquetesVigentes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorPaquetePublishService cpq = new ControladorPaquetePublishService();
		ControladorPaquetePublish port = cpq.getControladorPaquetePublishPort();
		RequestDispatcher rd;
		
		StringArray lUWB = port.listarPaquetesVigentes();
		List<String> paquetes = lUWB.getItem();
		
		if(paquetes.isEmpty()) {
			request.setAttribute("mensaje", "no hay paquetes disponibles en el sistema");
		}else {
			request.setAttribute("mensaje", "seleccione el paquete que desea comprar");
			request.setAttribute("listaPaquetesVigentes", paquetes);
		}
				
		rd = request.getRequestDispatcher("/comprarPaquete.jsp");
		rd.forward(request, response);
		
	}

}
