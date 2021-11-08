package servlets;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.io.FileUtils;

import publicadores.ControladorFuncionPublish;
import publicadores.ControladorFuncionPublishService;

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
		ControladorFuncionPublishService cps = new ControladorFuncionPublishService();
		ControladorFuncionPublish port = cps.getControladorFuncionPublishPort();
		RequestDispatcher rd;
		
		String espectaculo = request.getParameter("espectaculoElegido");
		String nombreFuncion = request.getParameter("nombreFuncion");
		String fechaF = request.getParameter("fecha");
		String hora = request.getParameter("hora");
		LocalTime horaI = null;	
		String[] invitados = request.getParameterValues("invitados");	
		List<String> listaI = new ArrayList<String>(Arrays.asList(invitados));
		LocalDate fR = LocalDate.now();
		Date fDate;
		
		XMLGregorianCalendar fechaFuncion = null;
		try {
			fDate = new SimpleDateFormat("yyyy-MM-dd").parse(fechaF);
			System.out.println(fDate);	
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(fDate);
			fechaFuncion = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		XMLGregorianCalendar fRegistro = null;
		try {
			Date fBien = java.sql.Date.valueOf(fR);
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(fBien);
			fRegistro = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
        
        byte[] imagen = new byte[0];      
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
        
		
		
		DateTimeFormatter formatterH = DateTimeFormatter.ofPattern("HH:mm");
//		DateTimeFormatter formatterF = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
//		fechaRegistro.format(formatterF);
//		
		try {
			port.chequearDisponibilidadNombreFuncion(nombreFuncion);
			port.seleccionarEspectaculo(espectaculo);
			horaI = LocalTime.parse(hora, formatterH);
			Instant instant = horaI.atDate(LocalDate.of(2021,11,01)).atZone(ZoneId.systemDefault()).toInstant();
			Date time = Date.from(instant);
			
			XMLGregorianCalendar timeG = null;
			try {
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(time);
				timeG = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			ArrayList<String> l = null;
			publicadores.DtFuncion dtf = new publicadores.DtFuncion();
			dtf.setNombre(nombreFuncion);
			dtf.setFecha(fechaFuncion);
			dtf.setHoraIni(timeG);
			dtf.setFechaReg(fRegistro);
			port.ingresarFuncion(dtf, imagen);				
			if (listaI != null) {
				for(String s: listaI) {			
					try {
						port.ingresarArtista(s);
					} catch (Exception e) {
						request.setAttribute("mensaje", e.getMessage());
					}
				}
			}
			port.altaFuncion();
			request.setAttribute("mensaje", "La función se agregó correctamente.");
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}	
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
}