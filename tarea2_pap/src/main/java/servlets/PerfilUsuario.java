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

import datatypes.DtUsuario;
import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtFuncion;
import interfaces.Fabrica;
import interfaces.IControladorUsuario;
import interfaces.IControladorFuncion;

@WebServlet("/PerfilUsuario")
public class PerfilUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PerfilUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("usuario");		
				
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorUsuario icon = fabrica.getIControladorUsuario();
		IControladorFuncion iconF = fabrica.getIControladorFuncion();
		HttpSession sesion = request.getSession();
		String nickSesion = (String) sesion.getAttribute("nick");	
			
		DtUsuario dtu = icon.seleccionarUsuario(nick);
		try {
			String imagenURL = icon.getImagenUsuario(dtu.getNickName());
			request.setAttribute("imagen", imagenURL);	
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<DtFuncion> lR = null;
		if (dtu instanceof DtEspectador) {	
			lR = iconF.listarFuncionesEspectador(dtu.getNickName());			
			if (nickSesion != null && nickSesion.equals(dtu.getNickName())) {
				List<String> lP = icon.listarPaquetes(dtu.getNickName());
				request.setAttribute("listaPaquetesEspectador", lP);
				request.setAttribute("flag", "mostrarPaquetes");
			} else request.setAttribute("flag", "E");	
		}
		
		List<String> lS = icon.listarSeguidos(dtu.getNickName());
		List<String> lS2 = icon.listarSeguidores(dtu.getNickName());
		
		request.setAttribute("nick", dtu.getNickName());
		request.setAttribute("nombre", dtu.getNombre());	
		request.setAttribute("apellido", dtu.getApellido());	
		request.setAttribute("correo", dtu.getMail());		
		request.setAttribute("fnac", dtu.getFnac().toString());
		request.setAttribute("registro_funciones", lR);
		request.setAttribute("listaSeguidos", lS);			
		request.setAttribute("listaSeguidores", lS2);	
						
		if (dtu instanceof DtArtista) {	
			List<String> lE = icon.mostrarEspectaculosOrganizados(dtu.getNickName());
			request.setAttribute("espectaculos_organizados", lE);	
			request.setAttribute("descripcion", ((DtArtista) dtu).getDescripcion());	
			request.setAttribute("url", ((DtArtista) dtu).getURL());
			request.setAttribute("bio", ((DtArtista) dtu).getBiografia());
			request.setAttribute("flag", "A");
		}			
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/perfilUsuario.jsp");
		rd.forward(request, response);
	}

}
