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
	<% ArrayList<String> espectaculos = (ArrayList<String>) request.getAttribute("espectaculos"); 
	   String pt = (String) request.getAttribute("plataforma");	
	   String paq = (String) request.getAttribute("paquete"); %>		   	
	<div class="fondo">	
		<div class="container">
		  	<div class="row">	  			
	  			<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 
	  			<div class="col-4"></div>
				<div class="wrap-contact3">
					<form action="AgregarEspecPaquete" method="post" class="contact3-form validate-form">							
						<input type="hidden" name="plataforma" value="<%=pt%>">
						<input type="hidden" name="paquete" value="<%=paq%>">
						<h1 style="color:white;">Espectáculos disponibles</h1>										
						<div class="wrap-input3 validate-input">		
							<select name="espectaculo" class="form-select" required>
								<option selected disabled value="">Seleccione el espectáculo que desea agregar al paquete</option>					
							    <% if (espectaculos != null) {					      
								     for (String s: espectaculos) { %>				      		     
								  	     <option value="<%=s%>"><%=s%></option>						 
								  <% } 
								  } %>
							</select>	
						</div>
						<div class="container-contact3-form-btn">
							<button type="submit" class="contact3-form-btn col-6 mx-auto">Agregar espectáculo</button>
						</div>
					</form>
				</div>
			</div>	
		</div>
	</div>		
	<%@include file="/footer.jsp" %>
</body>			
</html>