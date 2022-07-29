package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;
import interfaces.IControladorPaquete;

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
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorPaquete icon = fabrica.getIControladorPaquete();
		RequestDispatcher rd;
		
		ArrayList<String> paquetes = icon.listarPaquetesVigentes();
		
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
