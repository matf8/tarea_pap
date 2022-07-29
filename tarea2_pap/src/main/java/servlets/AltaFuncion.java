package servlets;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import datatypes.DtFuncion;
import excepciones.PlataformaNoExisteException;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;

@WebServlet("/AltaFuncion")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
public class AltaFuncion extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "imagenes";
	private static final long serialVersionUID = 1L;

    public AltaFuncion() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String espectaculo = request.getParameter("espectaculoElegido");
		String nombreFuncion = request.getParameter("nombreFuncion");
		String fechaF = request.getParameter("fecha");
		LocalDate fecha = null;
		String hora = request.getParameter("hora");
		LocalTime horaI = null;	
		String[] invitados = request.getParameterValues("invitados");	
		List<String> listaI = new ArrayList<String>(Arrays.asList(invitados));		
		
		// si dejo seleccionado el valor por defecto lo borro
		if (listaI.contains("Seleccione los artistas que desea invitar")) {			
			listaI.remove("Seleccione los artistas que desea invitar");
		}
		
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + UPLOAD_DIRECTORY;		
		File fileSaveDir = new File(savePath);
		
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        byte[] imagen = null;        
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();         
            if (fileName != null && !"".equals(fileName)) {
            	part.write(savePath + File.separator + fileName);   
            	File img = new File(savePath + File.separator + fileName);
            	imagen = FileUtils.readFileToByteArray(img);
            }            
        }      
			
		LocalDate fechaRegistro = LocalDate.now();
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorFuncion icon = fabrica.getIControladorFuncion();
		RequestDispatcher rd;
		
		DateTimeFormatter formatterH = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter formatterF = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
		fechaRegistro.format(formatterF);
		
		try {
			icon.chequearDisponibilidadNombreFuncion(nombreFuncion);
			icon.seleccionarEspectaculo(espectaculo);
			horaI = LocalTime.parse(hora, formatterH);
			fecha = LocalDate.parse(fechaF);	
			ArrayList<String> l = null;
			DtFuncion dtf = new DtFuncion(nombreFuncion, fecha, horaI, fechaRegistro, l);
			icon.ingresarFuncion(dtf, imagen);				
			if (listaI != null) {
				for(String s: listaI) {			
					try {
						icon.ingresarArtista(s);
					} catch (Exception e) {
						request.setAttribute("mensaje", e.getMessage());
					}
				}
			}
			icon.altaFuncion();
			request.setAttribute("mensaje", "La función se agregó correctamente.");
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}	
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
}