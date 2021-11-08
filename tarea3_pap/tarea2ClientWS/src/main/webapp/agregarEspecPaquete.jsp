<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp" %>
<title>Paquete | Agregar espectáculo</title>
</head>
<body>
	<% ArrayList<String> plataformas = (ArrayList<String>) request.getAttribute("plataformas");
	   String paquete = (String) request.getAttribute("nombrePaqueteCont"); %>	
	 <div class="fondo">	
		<div class="container">
		  	<div class="row">	  			
	  			<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 
	  			<div class="col-4"></div>
				<div class="wrap-contact3">
					<form action="ListarEspectaculosPlataforma" method="post" class="contact3-form validate-form">							
						<input type="hidden" name="paquete" value="<%=paquete%>">
						<h1 style="color:white;">Plataformas disponibles</h1>
						<div class="wrap-input3 validate-input mt-4">					
							<select name="nombrePlataforma" class="form-select" required>
								<option selected disabled value="">Seleccione la plataforma</option>					
							    <% if (plataformas != null) {					      
								     for (String s: plataformas) { %>				      		     
								  	     <option value="<%=s%>"><%=s%></option>						 
								  <% } 
								  } %>
							</select>	
						</div>
						<div class="container-contact3-form-btn">
							<button type="submit" class="contact3-form-btn col-4 mx-auto">Seguir</button>
						</div>
					</form>
				</div>	
			</div>				
		</div>
	</div>
	<%@include file="/footer.jsp" %>	
</body>		
</html>