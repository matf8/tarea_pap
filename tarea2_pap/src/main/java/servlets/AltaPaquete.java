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

import interfaces.Fabrica;
import interfaces.IControladorPaquete;
import datatypes.DtPaquete;

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
		String paquete = request.getParameter("nombrePaquete");
		String fechaI = request.getParameter("fechaI");
		String fechaF = request.getParameter("fechaF");
		LocalDate fechaInicial = null;
		LocalDate fechaFinal = null;
		String descripcion = request.getParameter("descripcion");			
		String descuento = request.getParameter("descuento");		
		int idescuento = Integer.valueOf(descuento);

		LocalDate fechaRegistro = LocalDate.now();
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorPaquete icon = fabrica.getIControladorPaquete();
		RequestDispatcher rd;
		
		DateTimeFormatter formatterF = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
		fechaRegistro.format(formatterF);
		
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
		
		try {
			icon.chequearDisponibilidadPaquete(paquete);
			fechaInicial = LocalDate.parse(fechaI);
			fechaFinal = LocalDate.parse(fechaF);
			ArrayList<String> e = null;
			DtPaquete dtp = new DtPaquete(paquete, descripcion, fechaInicial, fechaFinal, fechaRegistro, idescuento, e);
			icon.ingresarDatosPaquete(dtp, imagen);				
			icon.altaPaquete();
			request.setAttribute("mensaje", "El paquete se agregó correctamente.");
		} catch (Exception e) {
			request.setAttribute("mensaje", e.getMessage());
		}	
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
}