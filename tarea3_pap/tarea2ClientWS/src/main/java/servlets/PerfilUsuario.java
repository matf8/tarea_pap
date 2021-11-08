package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.java.dev.jaxb.array.StringArray;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.DtFuncionArray;
import publicadores.ControladorFuncionPublish;
import publicadores.ControladorFuncionPublishService;

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
		HttpSession sesion = request.getSession();
		ControladorUsuarioPublishService cps = new ControladorUsuarioPublishService();
		ControladorUsuarioPublish portU = cps.getControladorUsuarioPublishPort();
		ControladorFuncionPublishService cpsf = new ControladorFuncionPublishService();
		ControladorFuncionPublish portF = cpsf.getControladorFuncionPublishPort();
		RequestDispatcher rd;
		
		String nickSesion = (String) sesion.getAttribute("nick");
		String nick = request.getParameter("usuario");
			
		publicadores.DtUsuario dtu = portU.seleccionarUsuario(nick);
		try {
			String imagenURL = portU.getImagenUsuario(dtu.getNickName());
			request.setAttribute("imagen", imagenURL);	
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<publicadores.DtFuncion> lR = null;
		if (dtu instanceof publicadores.DtEspectador) {	
			DtFuncionArray lRWB = portF.listarFuncionesEspectador(dtu.getNickName());	
			lR = lRWB.getItem();		
			if (nickSesion != null && nickSesion.equals(dtu.getNickName())) {
				StringArray lPWB = portU.listarPaquetes(dtu.getNickName());
				List<String> lP = lPWB.getItem();
				request.setAttribute("listaPaquetesEspectador", lP);
				request.setAttribute("flag", "mostrarPaquetes");
			} else request.setAttribute("flag", "E");	
		}
		
		StringArray lSWB = portU.listarSeguidos(dtu.getNickName());
		StringArray lFWB = portU.listarSeguidores(dtu.getNickName());
		List<String> lS = lSWB.getItem();
		List<String> lS2 = lFWB.getItem();
		
		request.setAttribute("nick", dtu.getNickName());
		request.setAttribute("nombre", dtu.getNombre());	
		request.setAttribute("apellido", dtu.getApellido());	
		request.setAttribute("correo", dtu.getMail());		
		request.setAttribute("fnac", dtu.getFnac().toString());
		request.setAttribute("registro_funciones", lR);
		request.setAttribute("listaSeguidos", lS);			
		request.setAttribute("listaSeguidores", lS2);	
						
		if (dtu instanceof publicadores.DtArtista) {	
			StringArray lEWB = portU.mostrarEspectaculosOrganizados(dtu.getNickName());
			List<String> lE = lEWB.getItem();
			request.setAttribute("espectaculos_organizados", lE);	
			request.setAttribute("descripcion", ((publicadores.DtArtista) dtu).getDescripcion());	
			request.setAttribute("url", ((publicadores.DtArtista) dtu).getUrl());
			request.setAttribute("bio", ((publicadores.DtArtista) dtu).getBiografia());
			request.setAttribute("flag", "A");
		}					
		
		rd = request.getRequestDispatcher("/perfilUsuario.jsp");
		rd.forward(request, response);
	}

}
