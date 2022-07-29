<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>

<title>Alta | Función</title>
</head>
<body>
	<% ArrayList<String> espectaculos = (ArrayList<String>)request.getAttribute("espectaculos");
	   ArrayList<String> invitados = (ArrayList<String>)request.getAttribute("artistas"); %>
	
	<div class="fondo">
		<div class="container">
			<div class="row">
				<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 	
				<div class="container mt-5 bg-secondary bg-gradient text-white">
					<form action="AltaFuncion" enctype="multipart/form-data" method="post" class="row g-2">					  	
					  	<div class="row">
						  	<div class="col-5 mt-4">
						  		<div class="wrap-input3 validate-input">
									<select class="form-select" name="espectaculoElegido" aria-label="Default select example" required>
										<option selected disabled value="">Seleccione un espectáculo</option>
											<% if (espectaculos != null)
												for (String e: espectaculos) { %>
													<option value="<%=e%>"><%=e%></option>
											<% } %>
									</select>	
								</div>
							 </div>			
							 <div class="col-5 mt-4">
							      <input type="text" class="form-control" placeholder="Nombre de la función" id="validationDefaultUsername" name="nombreFuncion" aria-describedby="inputGroupPrepend2" required>
							 </div>		   					
						 </div>					 
					     <div class="row">		  	  
						 	<div class="col-5 mt-2">
						    	<label for="fecha" class="form-label">Fecha</label>
						    	<input type="date" class="form-control" id="fecha" name="fecha" required>
						  </div>	
						  
						  <div class="col-5 mt-2">
							  <label for="hora" class="form-label">Hora [20:00]</label>
							  <input type="time" class="form-control" id="hora" name="hora" aria-describedby="inputGroupPrepend2" required>
						  </div>	
					  </div>	
					  
					  <div class="row">				
							<div class="col-5 mt-4">	
							 <div class="wrap-input3 validate-input">			
								<select name="invitados" class="form-select" multiple aria-label="multiple select example">
									<option selected>Seleccione los artistas que desea invitar</option>					
								    <% String nickname = (String) sesion.getAttribute("nick");					 
								  	   if (invitados != null) {					      
									     for (String i: invitados) { 
									       if (!i.equals(nickname)) { %>						     
									  	     <option value="<%=i%>"><%=i%></option>
										 <% }
										 } 
									   } %>
								</select>	
							</div>	
						  </div>									
						 <div class="col-5 mt-4">
							 	 <div class="wrap-input3 validate-input"> Subir portada				
									 <input class="input3" type="file" accept="image/png, image/gif, image/jpeg" size="60" name="filecover"> 			            	             		              				
							    </div>
							 </div>	
						 </div> 
						 	
						<button class="btn btn-danger col-2 mx-auto mb-2" type="submit" >Agregar función</button> 						
				   </form>			
				</div>			
		    </div>
		 </div>
	 </div>
	 <%@include file="/footer.jsp" %>
</body>
</html>