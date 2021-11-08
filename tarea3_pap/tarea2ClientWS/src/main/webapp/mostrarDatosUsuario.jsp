<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Mostrar datos usuario</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<% 
	String nickname = (String) request.getAttribute("nick");
	String nombre = (String) request.getAttribute("nombre");
	String apellido = (String) request.getAttribute("apellido");
	String fnac = (String) request.getAttribute("fnac");
	String mail = (String) request.getAttribute("mail");
	String desc = (String) request.getAttribute("desc");
	String url = (String) request.getAttribute("url");
	String bio = (String) request.getAttribute("bio");	
	String imagen = (String) request.getAttribute("imagen");
	String[] div = fnac.split("T");
	fnac = div[0];
	
	%>
	<div class="fondo">
		<div class="container">
			<div class="row">
				<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 
					<div class="container mt-5 bg-secondary bg-gradient text-white">
						<form action="ModificarUsuario" enctype="multipart/form-data" method="post" class="row g-3">
						  <div class="col-md-2">
						    <label for="validationDefaultUsername" class="form-label">Nickname</label>
						    <div class="input-group">
						      <span class="input-group-text" id="inputGroupPrepend2">@</span>
						      <input type="text" class="form-control" id="validationDefaultUsername" name="nickname" aria-describedby="inputGroupPrepend2" value="<%=nickname%>" readonly>
						    </div>
						  </div>
						  
						  <div class="col-md-4">
						    <label for="validationDefault01" class="form-label">Nombre</label>
						    <input type="text" class="form-control" id="validationDefault01" name="nombre" value="<%=nombre%>"required>
						  </div>
						  
						  <div class="col-md-4">
						    <label for="validationDefault02" class="form-label">Apellido</label>
						    <input type="text" class="form-control" id="validationDefault02" name="apellido" value="<%=apellido%>" required>
						  </div>
						  
						  <div class="col-md-3">
						    <label for="exampleInputEmail1" class="form-label">Email</label>
						    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="mail" value="<%=mail%>" readonly>
						    <div id="emailHelp" class="form-text text-white">Nunca compartiremos tu e-mail a nadie.</div>
						  </div>
						  
						  <div class="col-md-2">
						    <label for="validationDefault02" class="form-label">Fecha de nacimiento</label>
						    <input type="text" class="form-control" id="validationDefault02" name="fnac" value="<%=fnac%>"required>
						  </div>			 
						  
						   <div class="col-md-2">
						   	   <label for="validationDefault02" class="form-label">Foto de perfil</label>
 							   <% if (!imagen.isEmpty()) { %>										
									    <div class="col-md-12">
									      <img src="data:image/jpg;base64,<%=imagen%>" class="img-fluid rounded-start" alt="...">
									    </div>
								<% } else { %>
										<div class="col-md-12">
									      <img src="imagenes/userPlaceholder.png" class="img-fluid rounded-start" alt="...">
									    </div>									
								<% } %>
						  </div>						  
						   
						  <div class="col-md-2">
						  	  <input type="radio" class="btn-check" name="options" id="option2" autocomplete="off" value="cambio" data-toggle="collapse" data-target=".multi-collapse" aria-expanded="false" aria-controls="multiCollapseExample1 multiCollapseExample2 multiCollapseExample3">
							  <label class="btn btn-secondary" for="option2">Cambiar foto de perfil</label>
						  </div>
						  
						   <div class="collapse multi-collapse" id="multiCollapseExample1">
						  	 <div class="col-6"></div>
						  	 <div class="col-md-6">
							 	 <div class="wrap-input3 validate-input"> Subir foto de perfil			
									 <input class="input3" type="file" accept="image/png, image/gif, image/jpeg" size="60" name="filecover"> 			            	             		              				
							    </div>
							 </div>	 
						   </div>
						  					  
						<div class="col-md-12"></div>						
						<%if (tipo.equals("artista")){ %>
							  <div class="col-md-4">
							    <label for="validationDefault02" class="form-label">Biografia</label>
							    <textarea class="form-control" id="validationDefault02" name="bio"><%=bio%></textarea>
							  </div>
							  
							  <div class="col-md-4">
							    <label for="validationDefault02" class="form-label">Url</label>
							    <input type="text" class="form-control" id="validationDefault02" name="url" value="<%=url%>">
							  </div>
							  
							  <div class="col-md-4">
							    <label for="validationDefault02" class="form-label">Descripción</label>
							    <textarea class="form-control" id="validationDefault02" name="desc"><%=desc%></textarea>
							  </div>
						 <%} %>
						 
						  <div class="col-2">
						    <button class="btn btn-danger mb-2" type="submit">Modificar</button>
						  </div>
						</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/footer.jsp" %>
</body>
</html>