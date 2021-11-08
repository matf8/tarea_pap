package servlets;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

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

import publicadores.ControladorPaquetePublish;
import publicadores.ControladorPaquetePublishService;

@WebServlet("/AltaPaquete")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
public class AltaPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "imagenes";

    public AltaPaquete() {
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
		
		ControladorPaquetePublishService cps = new ControladorPaquetePublishService();
		ControladorPaquetePublish port = cps.getControladorPaquetePublishPort();	
		RequestDispatcher rd;
		
		String paquete = request.getParameter("nombrePaquete");
		String fechaI = request.getParameter("fechaI");
		String fechaF = request.getParameter("fechaF");
		LocalDate fechaInicial = null;
		LocalDate fechaFinal = null;
		String descripcion = request.getParameter("descripcion");			
		String descuento = request.getParameter("descuento");		
		Float idescuento = Float.valueOf(descuento);
		LocalDate fechaRegistro = LocalDate.now();	
		DateTimeFormatter formatterF = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
		fechaRegistro.format(formatterF);
				
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
        
        Date fIDate = null, fFDate = null;
		XMLGregorianCalendar fIG = null, fFG = null, fR = null;
		
		
		try {			
			port.chequearDisponibilidadPaquete(paquete);
			
			fIDate = new SimpleDateFormat("yyyy-MM-dd").parse(fechaI);			
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(fIDate);
			fIG = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			
			fFDate = new SimpleDateFormat("yyyy-MM-dd").parse(fechaF);			
			GregorianCalendar c2 = new GregorianCalendar();
			c2.setTime(fFDate);
			fFG = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);	
			
			Date fReg = java.sql.Date.valueOf(fechaRegistro);
			GregorianCalendar c3 = new GregorianCalendar();
			c.setTime(fReg);
			fR = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			
			publicadores.DtPaquete dtp = new publicadores.DtPaquete();
			dtp.setNombre(paquete);
			dtp.setDescripcion(descripcion); 
			dtp.setFechaInicio(fIG);
			dtp.setFechaFin(fFG);
			dtp.setFechaRegistro(fR);
			dtp.setDescuento(idescuento);		
			port.ingresarDatosPaquete(dtp, imagen);				
			port.altaPaquete();
			request.setAttribute("mensaje", "El paquete se agregó correctamente.");
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}	
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
}