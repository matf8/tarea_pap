package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;

import datatypes.DtEspectaculo;

import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;

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
		LocalDate f = LocalDate.now();	
		Integer iduracion = Integer.valueOf(request.getParameter("duracion"));
		Integer icantMaxEspec= Integer.valueOf(request.getParameter("cantMax"));
		Integer icantMinEspec = Integer.valueOf(request.getParameter("cantMin"));
		Float icosto = Float.valueOf(request.getParameter("costo"));	
		
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
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorEspectaculo icon = fabrica.getIControladorEspectaculo();
		RequestDispatcher rd;		
		
		try {
			icon.chequearDisponibilidadNombre(nombreEspectaculo);			
			DtEspectaculo dte = new DtEspectaculo (nombreEspectaculo, descripcion, url, iduracion, icantMaxEspec, icantMinEspec, icosto, f, artistaOrg, nombrePlataforma);
			icon.ingresarEspectaculo(nombrePlataforma, artistaOrg, dte, imagen);
			icon.altaEspectaculo();
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