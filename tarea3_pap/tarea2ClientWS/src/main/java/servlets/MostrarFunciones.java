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

import publicadores.ControladorFuncionPublish;
import publicadores.ControladorFuncionPublishService;
import publicadores.EspectaculoNoValidoException_Exception;

@WebServlet("/MostrarFunciones")
public class MostrarFunciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MostrarFunciones() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomEspectaculo = request.getParameter("espectaculoElegido");
		ControladorFuncionPublishService cps = new ControladorFuncionPublishService();
		ControladorFuncionPublish port = cps.getControladorFuncionPublishPort();
		
		List<String> lF = new ArrayList<>();
		
		try {
			port.seleccionarEspectaculo(nomEspectaculo);
			lF = port.listarFuncionesVigentes().getItem();
			request.setAttribute("funciones", lF);
			request.setAttribute("espectaculo", nomEspectaculo);
		} catch (EspectaculoNoValidoException_Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/mostrarFunciones.jsp");
		rd.forward(request, response);
	}

}