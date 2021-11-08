package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;

@WebServlet("/MostrarDatosUsuario")
public class MostrarDatosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MostrarDatosUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String nick = (String)sesion.getAttribute("nick");
		String tipo = (String)sesion.getAttribute("tipoSesion");			
		RequestDispatcher rd;
		ControladorUsuarioPublishService cps = new ControladorUsuarioPublishService();
		ControladorUsuarioPublish port = cps.getControladorUsuarioPublishPort();	
			
		if(tipo.equals("artista")) {
			publicadores.DtArtista artista = (publicadores.DtArtista) port.seleccionarUsuario(nick);
			request.setAttribute("desc", artista.getDescripcion());
			request.setAttribute("url", artista.getUrl());
			request.setAttribute("bio", artista.getBiografia());
		}			
		try {
			publicadores.DtUsuario user = port.seleccionarUsuario(nick);
			request.setAttribute("nick", user.getNickName());
			request.setAttribute("mail", user.getMail());
			request.setAttribute("nombre", user.getNombre());
			request.setAttribute("apellido", user.getApellido());
			request.setAttribute("fnac", user.getFnac().toString());		
			request.setAttribute("imagen", port.getImagenUsuario(nick));
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}
		
		rd = request.getRequestDispatcher("/mostrarDatosUsuario.jsp");
		rd.forward(request, response);	
	}

}
