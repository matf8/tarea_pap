package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
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

import datatypes.DtEspectador;
import datatypes.DtFuncion;
import datatypes.DtRegistroCompleto;
import interfaces.Fabrica;
import interfaces.IControladorFuncion;
import interfaces.IControladorUsuario;

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
		
		HttpSession sesion = request.getSession();
		String nick = (String) sesion.getAttribute("nick"); 
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorFuncion icon = fabrica.getIControladorFuncion();		
		RequestDispatcher rd;
		
		String funcion = request.getParameter("nombreFuncion_Registros");	
		String espectaculo = request.getParameter("espectaculo_Registros");
		String[] registrosParaCanjear = request.getParameterValues("registroElegido");
		
		List<Integer> rIndS = new ArrayList<>();
		List<String> rS = new ArrayList<>();			
		if (registrosParaCanjear != null) 
				rS = Arrays.asList(registrosParaCanjear);	
		
		if (rS.size() != 0) {
			try {
				icon.seleccionarEspectaculo(espectaculo);
				List<String> paquetes = icon.listarPaquetes(nick);		
				List<DtRegistroCompleto> reg = icon.listarRegistros(nick);	
				DtFuncion dtf = icon.seleccionarFuncion(funcion);
				int tmp;				
				for (int i=0; (i < 3 && i < registrosParaCanjear.length); i++) {
					tmp = Integer.valueOf(registrosParaCanjear[i]);
					rIndS.add(tmp);		
				}
				
				if (rIndS.size() == 3) {			
					icon.altaRegistro(rIndS);		
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
