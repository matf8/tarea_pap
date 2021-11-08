package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.io.FileUtils;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;

import publicadores.ControladorEspectaculoPublish;
import publicadores.ControladorEspectaculoPublishService;

@WebServlet("/AltaEspectaculo")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
public class AltaEspectaculo extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "imagenes";
	private static final long serialVersionUID = 1L;
       
    public AltaEspectaculo() {
        super();
    }
     

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombrePlataforma = request.getParameter("nombrePlataforma");
		String nombreEspectaculo = request.getParameter("nombreEspectaculo");	
		String artistaOrg = request.getParameter("artistaOrg");
		String descripcion = request.getParameter("descripcion");		
		String url = request.getParameter("url");
		Integer iduracion = Integer.valueOf(request.getParameter("duracion"));
		Integer icantMaxEspec= Integer.valueOf(request.getParameter("cantMax"));
		Integer icantMinEspec = Integer.valueOf(request.getParameter("cantMin"));
		Float icosto = Float.valueOf(request.getParameter("costo"));
		LocalDate f = LocalDate.now();
		
		XMLGregorianCalendar fnac = null;
		try {
			Date fBien = java.sql.Date.valueOf(f);
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(fBien);
			fnac = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ControladorEspectaculoPublishService cps = new ControladorEspectaculoPublishService();
		ControladorEspectaculoPublish port = cps.getControladorEspectaculoPublishPort();	
		
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
		
		RequestDispatcher rd;		
		
		try {
			port.chequearDisponibilidadNombre(nombreEspectaculo);			
			publicadores.DtEspectaculo dte = new publicadores.DtEspectaculo();
			dte.setNombre(nombreEspectaculo);
			dte.setDescripcion(descripcion);
			dte.setURL(url);
			dte.setDuracion(iduracion);
			dte.setCantMax(icantMaxEspec);
			dte.setCantMin(icantMinEspec);
			dte.setCosto(icosto);
			dte.setFechaReg(fnac);
			dte.setOrganizador(artistaOrg);
			dte.setPlataforma(nombrePlataforma);
			port.ingresarEspectaculo(nombrePlataforma, artistaOrg, dte, imagen);
			port.altaEspectaculo();
			request.setAttribute("mensaje", "Se ha ingresado correctamente al espectaculo " + nombreEspectaculo + " en el sistema.");
			
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());		
		}		
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);	
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
}