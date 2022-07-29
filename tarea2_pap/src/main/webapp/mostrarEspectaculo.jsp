<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Registro | Espectáculos </title>
</head>
<body>	
	<% ArrayList<String> espectaculos = (ArrayList<String>) request.getAttribute("espectaculos"); %>
	<div class="fondo">	
		<div class="container">
	  		<div class="row">	  			
	  			<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 
	  			<div class="col-4"></div>
				<div class="wrap-contact3">
					<form action="MostrarFunciones" method="post" class="contact3-form validate-form">							
						<span class="contact3-form-title"> Espectáculos disponibles	</span>								
							<div class="wrap-input3 validate-input"> 
								<!-- <h4 style="text-align:left color:white">Seleccione el espectáculo que se desea registrar</h4> -->														
								<select name="espectaculoElegido" id="validationCustom04" class="form-select" required> 	
							  	  <% if (espectaculos != null && espectaculos.size() != 0) {					      
								    	 for (String s: espectaculos) { %>				      		     
								  	    	 <option value="<%=s%>"><%=s%></option>						 
								  <% }
							  	  }else { %>
									  <option selected disabled value="">Seleccione el espectáculo que se desea registrar</option>
	
								  <% } %>
								</select>
							</div>	
							 <% if (espectaculos != null && espectaculos.size() != 0) { %>														
							<div class="container-contact3-form-btn">
								<button type="submit" class="contact3-form-btn col-6 mx-auto">Siguiente</button>
							</div>	
							<% } %>									
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/footer.jsp" %>
</body>
</html>
