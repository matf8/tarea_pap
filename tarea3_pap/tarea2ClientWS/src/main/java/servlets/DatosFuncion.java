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
import javax.servlet.http.HttpSession;

import publicadores.ControladorFuncionPublish;
import publicadores.ControladorFuncionPublishService;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.DtFuncion;
import publicadores.DtRegistroCompleto;

@WebServlet("/DatosFuncion")
public class DatosFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DatosFuncion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String funcion = request.getParameter("funcionElegida");
		String espectaculo = request.getParameter("espectaculo");
		HttpSession sesion = request.getSession();
		String nick = (String) sesion.getAttribute("nick"); 

		ControladorFuncionPublishService cps = new ControladorFuncionPublishService();
		ControladorFuncionPublish portF = cps.getControladorFuncionPublishPort();
		ControladorUsuarioPublishService cpu = new ControladorUsuarioPublishService();
		ControladorUsuarioPublish portU = cpu.getControladorUsuarioPublishPort();	
		
		publicadores.DtEspectador dte = (publicadores.DtEspectador) portU.seleccionarUsuario(nick); 		
		
		RequestDispatcher rd;				
		
		List<String> aux = new ArrayList<String>();
		
		try {
			List<DtRegistroCompleto> reg = portF.listarRegistros(nick).getItem();	
			for(int i=0; i<reg.size(); i++) {
				aux.add("Registro:" + reg.get(i).getId() + ":Funcion: " + reg.get(i).getNombreFuncion());
				System.out.println(aux.get(i));
			}
			
			portF.seleccionarEspectaculo(espectaculo);
			List<String> paquetes = portF.listarPaquetes(nick).getItem();		
						
			portF.seleccionarEspectaculo(espectaculo);
			DtFuncion dtf = portF.seleccionarFuncion(funcion);
			request.setAttribute("nombreF", dtf.getNombre());
			request.setAttribute("fecha", dtf.getFecha().toString());
			request.setAttribute("hora", dtf.getHoraIni().toString());	
			request.setAttribute("registros", aux);	
			request.setAttribute("paquetes", paquetes);	
			request.setAttribute("espectaculo", espectaculo);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mensaje", e.getMessage());
		}		
		rd = request.getRequestDispatcher("/datosFuncion.jsp");
		rd.forward(request, response);	
		}	
	
}
