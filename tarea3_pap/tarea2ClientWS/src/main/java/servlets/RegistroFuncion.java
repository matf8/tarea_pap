package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.java.dev.jaxb.array.IntArray;
import net.java.dev.jaxb.array.ObjectFactory;
import publicadores.ControladorFuncionPublish;
import publicadores.ControladorFuncionPublishService;
import publicadores.DtRegistroCompletoArray;

@WebServlet("/RegistroFuncion")
public class RegistroFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegistroFuncion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorFuncionPublishService cps = new ControladorFuncionPublishService();
		ControladorFuncionPublish port = cps.getControladorFuncionPublishPort();
		RequestDispatcher rd;
		String funcion = request.getParameter("nombreF");	
		String espectaculo = request.getParameter("espectaculo");
		
		HttpSession sesion = request.getSession();
		String nick = (String) sesion.getAttribute("nick"); 	
		ObjectFactory rc = new ObjectFactory();
		IntArray rIndS = rc.createIntArray();		
		try {
			port.seleccionarEspectaculo(espectaculo);
			publicadores.DtFuncion dtf = port.seleccionarFuncion(funcion);	
			DtRegistroCompletoArray reg = port.listarRegistros(nick);	
			port.altaRegistro(rIndS);
			request.setAttribute("mensaje", "Registro creado exitosamente");
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}		
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);	
	}

}
