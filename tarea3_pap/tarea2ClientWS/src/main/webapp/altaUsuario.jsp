<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Alta | Usuario</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<div class="fondo">
		<div class="container">
			<div class="row">
				<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 	  			  						
				<div class="container mt-5 bg-secondary bg-gradient text-white">				
					<form action="AltaUsuario" enctype="multipart/form-data" name="alta" method="post" class="row g-3" oninput='up2.setCustomValidity(up2.value != up.value ? "Las contraseñas no coinciden." : "")'>
					  
					  <div class="col-md-2">
					    <label for="validationDefaultUsername" class="form-label">Nickname</label>
					    <div class="input-group">
					      <span class="input-group-text" id="inputGroupPrepend2">@</span>
					      <input type="text" class="form-control" id="validationDefaultUsername" name="nickname" aria-describedby="inputGroupPrepend2" required>
					    </div>
					  </div>
					  
					  <div class="col-md-4">
					    <label for="validationDefault01" class="form-label">Nombre</label>
					    <input type="text" class="form-control" id="validationDefault01" name="nombre">
					  </div>
					  
					  <div class="col-md-4">
					    <label for="validationDefault02" class="form-label">Apellido</label>
					    <input type="text" class="form-control" id="validationDefault02" name="apellido">
					  </div>
					  
					  <div class="col-md-3">
					    <label for="password1" class="form-label">Contraseña</label>
					    <input id="password1" class="form-control" type="password" name="up" required>
					  </div>
					  
					  <div class="col-md-3">
					    <label for="password2" class="form-label">Confirmar contraseña</label>
					    <input id="password2" class="form-control" type="password" name="up2">
					  </div>
					  
					  		<div class="col-md-3">
					    <label for="exampleInputEmail1" class="form-label">Email</label>
					    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="mail" required>
					    <div id="emailHelp" class="form-text text-white">Nunca compartiremos tu e-mail a nadie.</div>
					  </div>
					  
					  <div class="col-md-2">
					    <label for="validationDefault02" class="form-label">Fecha de nacimiento</label>
					    <input type="date" class="form-control" id="validationDefault02" name="fnac" required>
					  </div>
					  	  
					  <input type="hidden" name="aux">
					  
					  <div class="col-md-2">
						  <input type="radio" class="btn-check btn-primary" name="options" id="option1" autocomplete="off" value="espectador" onclick="{document.alta.aux.value=this.value;}" checked>
						  <label class="btn btn-secondary" for="option1">Espectador</label>
					  </div>
					  
					  <div class="col-md-2">
					  	  <input type="radio" class="btn-check" name="options" id="option2" autocomplete="off" value="artista" data-toggle="collapse" data-target=".multi-collapse" aria-expanded="false" aria-controls="multiCollapseExample1 multiCollapseExample2 multiCollapseExample3" onclick="{document.alta.aux.value=this.value;}">
						  <label class="btn btn-secondary" for="option2">Artista</label>
					  </div>
					  
					  <div class="col-md-6">
					 	 <div class="wrap-input3 validate-input"> Subir foto de perfil			
							 <input class="input3" type="file" accept="image/png, image/gif, image/jpeg" size="60" name="filecover"> 			            	             		              				
					    </div>
					  </div>						  								  	 
					 
					  <div class="col-md-4 collapse multi-collapse" id="multiCollapseExample1">
					    <label for="biografia" class="form-label">Biografia</label>
					    <textarea class="form-control" id="biografia" name="bio"></textarea>
			     	  </div>
					  
					  <div class="col-md-4 collapse multi-collapse" id="multiCollapseExample2">
					    <label for="url" class="form-label">Url</label>
					    <input type="text" class="form-control" id="url" name="url">
					  </div>
					  
					  <div class="col-md-4 collapse multi-collapse" id="multiCollapseExample3">
					    <label for="descripcion" class="form-label">Descripcion</label>
					    <textarea class="form-control" id="descripcion" name="desc"></textarea>
					  </div>	
					  			
					   <div class="col-12">
						<button class="btn btn-light mb-2" style="" type="submit" >Registrarse</button>
					  </div>		  
					</form>					
				</div>
			</div>
		</div>
	</div>
	<%@include file="/footer.jsp" %>
</body>
</html>