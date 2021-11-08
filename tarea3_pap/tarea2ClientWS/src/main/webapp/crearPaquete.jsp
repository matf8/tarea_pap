<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Alta | Paquete</title>
</head>
<body>

	<div class="fondo">
		<div class="container">
			<div class="row">
				<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 	
			<div class="container mt-5 bg-secondary bg-gradient text-white">
				<form action="AltaPaquete" enctype="multipart/form-data" method="post" class="row g-3">	 												
					<div class="row">
				  		<div class="col-5 mt-4">			
					     	  <input type="text" class="form-control" id="validationDefaultUsername" name="nombrePaquete" placeholder="Nombre de paquete" aria-describedby="inputGroupPrepend2" required>
						 </div>
						 
						<div class="col-5 mt-4">
						    <input type="text" class="form-control" id="validationDefault01" name="descripcion" placeholder="Descripción" required>
						  </div>
						 			 
					</div>
					
					<div class="row">
						<div class="col-3 mt-2">			
					  		  <label for="validationDefaultUsername" class="form-label">Fecha Inicio</label>
					     	  <input type="date" class="form-control" id="validationDefaultUsername" name="fechaI" aria-describedby="inputGroupPrepend2" required>
						 </div>	
						 <div class="col-3 mt-2">			
					  		  <label for="validationDefaultUsername" class="form-label">Fecha Final</label>
					     	  <input type="date" class="form-control" id="validationDefaultUsername" name="fechaF" aria-describedby="inputGroupPrepend2" required>		
						</div>
						
						<div class="col-1 mt-2">			
							<div class="wrap-input3 validate-input"> <p style="color:white"> Descuento %</p>
								<input type="number" min="1" max="100" name="descuento" id="myPercent" required/> 
								<span class="focus-input3"></span>
							</div>				 
						</div>
					</div>
																											
					<div class="col-4 mt-4">
					 	 <div class="wrap-input3 validate-input"> Subir portada				
							 <input class="input3" type="file" accept="image/png, image/gif, image/jpeg" size="60" name="filecover"> 			            	             		              				
					    </div>
				   </div>	 
		              	
				<div class="col-12 mb-2">
		   			<button class="btn btn-light" type="submit" class="contact3-form-btn">Agregar paquete</button>
				</div>						
				</form>			
			 </div>			
		 </div>
	  </div>
	 </div>
	 <%@include file="/footer.jsp" %>
</body>
</html>