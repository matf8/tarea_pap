 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/header.jsp" %>
	<title>Alta | Espectáculo</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">	
</head>
<body>
	<div class="fondo">
		<div class="container">
			<div class="row">
				<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 	
				  <div class="container mt-5 bg-secondary bg-gradient text-white">
					<form action="AltaEspectaculo" enctype="multipart/form-data" method="post" class="row g-3">	  
					  
					  <div class="col-md-4">
					    <label for="validationDefaultUsername" class="form-label">Nombre de Plataforma</label>
					      <input type="text" class="form-control" id="validationDefaultUsername" name="nombrePlataforma" aria-describedby="inputGroupPrepend2" required>
					  </div>
					  
					  <div class="col-md-4">
					    <label for="validationDefault01" class="form-label">Nombre de espectáculo</label>
					    <input type="text" class="form-control" id="validationDefault01" name="nombreEspectaculo" required>
					  </div>
					  
					  <div class="col-md-4">
					    <label for="validationDefault02" class="form-label">Artista organizador</label>
					    <input type="text" class="form-control" id="validationDefault02" name="artistaOrg" required>
					  </div>
					  
					  <div class="col-md-4">
						  <label for="validationDefault02" class="form-label">Descripción</label>
						  <textarea class="form-control" id="validationDefault02" name="descripcion"></textarea>
					  </div>  
					  
					  <div class="col-md-4">
					    <label for="validationDefault01" class="form-label">Cantidad mínima de espectadores</label>
					    <input type="text" class="form-control" id="validationDefault01" name="cantMin" required>
					  </div>	
					  
					   <div class="col-md-4">
					    <label for="validationDefault01" class="form-label">Cantidad máxima de espectadores</label>
					    <input type="text" class="form-control" id="validationDefault01" name="cantMax" required>
					  </div>
					  
					   <div class="col-md-4">
					    <label for="validationDefault01" class="form-label">Duración</label>
					    <input type="text" class="form-control" id="validationDefault01" name="duracion" required>
					  </div>
					
					  <div class="col-md-4">
					    <label for="validationDefault01" class="form-label">URL</label>
					    <input type="text" class="form-control" id="validationDefault01" name="url">
					  </div>
					  
					   <div class="col-md-4">
					     <label for="validationDefault01" class="form-label">Costo</label>
					     <input type="text" class="form-control" id="validationDefault01" name="costo" required>
					  </div>
					  	
					  <div class="col-md-6">
					 	 <div class="wrap-input3 validate-input"> Subir portada				
							 <input class="input3" type="file" accept="image/png, image/gif, image/jpeg" size="60" name="filecover"> 			            	             		              				
					    </div>
					 </div>	    
					  	 
					 <div class="col-12 mb-2">
					   <button class="btn btn-light" type="submit">Ingresar</button>
					 </div>					 					  
					</form>
				  </div>
				 </div>
			</div>
		 </div>
  <%@include file="/footer.jsp" %>
</body>
</html>