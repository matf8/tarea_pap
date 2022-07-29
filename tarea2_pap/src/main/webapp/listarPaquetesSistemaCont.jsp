<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/header.jsp" %>
	<title>Paqutes | Agregar espectáculo</title>
</head>
<body>	
	<% ArrayList<String> listaPaquetes = (ArrayList<String>) request.getAttribute("paquetes"); %>
		<div class="fondo">	
			<div class="container">
		  		<div class="row">	  			
		  			<div class="container mt-4"> </div> 	
		  			<div class="container mt-4"> </div> 
		  			<div class="col-4"></div>
					<div class="wrap-contact3">
						<form action="ListarPlataformas" method="post" class="contact3-form validate-form">							
							<h1>Paquetes disponibles</h1>								
								<div class="wrap-input3 validate-input mt-2">						
									<select name="nombrePaquete" class="form-select" required>
										<option selected disabled value="">Seleccione el paquete que desea agregar un espectáculo</option>		
									  	  <% if (listaPaquetes != null) {					      
										    	 for (String s: listaPaquetes) { %>				      		     
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