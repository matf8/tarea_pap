package servlets;

import java.io.IOException;
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

import publicadores.ControladorFuncionPublish;
import publicadores.ControladorFuncionPublishService;
import publicadores.DtRegistroCompletoArray;
import net.java.dev.jaxb.array.StringArray;
import net.java.dev.jaxb.array.IntArray;
import net.java.dev.jaxb.array.ObjectFactory;



@WebServlet("/CanjearRegistros")
public class CanjearRegistros extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CanjearRegistros() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ControladorFuncionPublishService cps = new ControladorFuncionPublishService();
		ControladorFuncionPublish port = cps.getControladorFuncionPublishPort();
		RequestDispatcher rd;				
		HttpSession sesion = request.getSession();
		
		String nick = (String) sesion.getAttribute("nick"); 						
		String funcion = request.getParameter("nombreFuncion_Registros");	
		String espectaculo = request.getParameter("espectaculo_Registros");
		String[] registrosParaCanjear = request.getParameterValues("registroElegido");
	
		ObjectFactory rc = new ObjectFactory();
		IntArray rIndS = rc.createIntArray();
		//ArrayList<Integer> rIndS = new ArrayList<>();
		List<String> rS = new ArrayList<>();			
		if (registrosParaCanjear != null) 
				rS = Arrays.asList(registrosParaCanjear);	
		
		
		if (rS.size() != 0) {
			try {
				port.seleccionarEspectaculo(espectaculo);
				StringArray paquetes = port.listarPaquetes(nick);		
				DtRegistroCompletoArray reg = port.listarRegistros(nick);	
				publicadores.DtFuncion dtf = port.seleccionarFuncion(funcion);
				int tmp;				
				for (int i=0; (i < 3 && i < registrosParaCanjear.length); i++) {
					String[] div = registrosParaCanjear[i].split(":");	
					registrosParaCanjear[i] = div[1];
					tmp = Integer.valueOf(registrosParaCanjear[i]);
					rIndS.getItem().add(tmp);		
				}
				
				if (rIndS.getItem().size() == 3) {							
					port.altaRegistro(rIndS);		
					request.setAttribute("mensaje", "Registro canjeado exitosamente");	
				} else {
					request.setAttribute("mensaje", "El canjeo deben ser exactamente 3 registros.");
				}			
			} catch (Exception e) {
				request.setAttribute("mensaje", e.getMessage());
			}		
		} else request.setAttribute("mensaje", "No eligió ningún registro.");

		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);	
	}

}
