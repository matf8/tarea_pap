package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datatypes.DtFuncion;
import excepciones.PlataformaNoExisteException;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorPaquete;

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
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorPaquete icon = fabrica.getIControladorPaquete();
		RequestDispatcher rd;
		
		try {
			icon.comprarPaquete(paquete, nickEspectador);
			request.setAttribute("mensaje", "El Paquete fue comprado correctamente.");
			rd = request.getRequestDispatcher("/index.jsp");
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
			request.setAttribute("listaPaquetesVigentes", icon.listarPaquetesVigentes());
			rd = request.getRequestDispatcher("/comprarPaquete.jsp");
		}	
		
		rd.forward(request, response);
	}
}