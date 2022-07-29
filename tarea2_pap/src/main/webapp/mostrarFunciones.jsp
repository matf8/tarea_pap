<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Registro | Funciones </title>
</head>
<body>	
	<% ArrayList<String> funciones = (ArrayList<String>) request.getAttribute("funciones");
	   String espectaculo = (String) request.getAttribute("espectaculo"); %>
	
	 <div class="fondo">	
			<div class="container">
		  		<div class="row">	  			
		  			<div class="container mt-4"> </div> 	
		  			<div class="container mt-4"> </div> 
		  			<div class="col-4"></div>
					<div class="wrap-contact3">
						<form action="DatosFuncion" method="post" class="contact3-form validate-form">							
							<span class="contact3-form-title"> Funciones disponibles de <%=espectaculo%></span>								
								<div class="wrap-input3 validate-input">	
									<input type="hidden" name="espectaculo" value="<%=espectaculo%>">					
									<select name="funcionElegida" id="validationCustom04" class="form-select" required>										
									  	 <% if (funciones != null && funciones.size() != 0) {					      
										    	 for (String s: funciones) { %>				      		     
										  	    	 <option value="<%=s%>"><%=s%></option>											  	    							 
										 		<% } 
										  } else { %> 
										  	<option selected disabled value="">No hay funciones disponibles</option>	 		
										 <% } %>		  
										  			
									</select>
								</div>	
								<% if (funciones != null && funciones.size() != 0) { %>									
										<button type="submit" class="contact3-form-btn col-6 mx-auto">Siguiente</button>
								<% } %>																					
						</form>
					</div>
				</div>
		</div>
	</div>
	<%@include file="/footer.jsp" %>
</body>
</html>