<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Función | Información</title>
</head>
<body>		
	<%
	String nombre = (String) request.getAttribute("nombre");
	String fecha = (String) request.getAttribute("fecha");
	String hora = (String) request.getAttribute("hora");
	String fechaReg = (String) request.getAttribute("fechaReg");
	ArrayList<String> invitados = (ArrayList<String>)request.getAttribute("invitados");
	String imagen = (String) request.getAttribute("imagen");	
	%>	
	<div class="fondo">
		<div class="container">
			<div class="row">
				<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 
	  			<div class="container col-5 bg-secondary bg-gradient text-black">
	  				<nav>
				 		 <div class="nav nav-tabs" id="nav-tab" role="tablist">
				 		 	 <button class="nav-link active" style="color:black" id="datosFuncion" data-bs-toggle="tab" data-bs-target="#datos" type="button" role="tab" aria-controls="datos" aria-selected="true">Datos de la función</button>
				 		  	 <button class="nav-link" id="a" style="color:black" data-bs-toggle="tab" data-bs-target="#artistas" type="button" role="tab" aria-controls="artistas" aria-selected="false">Artistas</button>
				 		  </div>
	  				</nav>  				
	  				<div class="tab-content" id="nav-tabContent">
						<div class="tab-pane fade show active" id="datos" role="tabpanel" aria-labelledby="datosFuncion">
				  			<div class="container col-8">
								<div class="card text-white bg-dark mb-3" style="max-width: 540px;">
		  							<div class="row g-0">
									     <% if (imagen != null) { %>										
									   		 <div class="text-center">
									    		  <img src="data:image/jpg;base64,<%=imagen%>" class="img-fluid rounded-start" alt="...">
									   		 </div>
										<% } else { %>
										    <div class="text-center">
										      	<img src="imagenes/placeholderFoto.jpg" class="img-fluid rounded-start" alt="...">
										    </div>									
										<% } %>
									    <div class="col-md-12">
									      <div class="card-body" style="color:white">
									        <h5 class="card-title" style="color:white"><%=nombre%></h5>
									        <p class="card-text" style="color:white"><small>Fecha: <%=fecha%></small></p>
									        <p class="card-text" style="color:white"><small>Hora inicio: <%=hora%></small></p>
									        <p class="card-text" style="color:white"><small>Fecha de registro: <%=fechaReg%></small></p>
									      </div>
									    </div>
									  </div>	  						
		  						</div>  							
	  						</div>
						</div>
						
						<div class="tab-pane fade" id="artistas" role="tabpanel" aria-labelledby="a">			  
							<div class="container col-8">
								<form action="PerfilUsuario" name="frm" method="post">
									<input type="hidden" name="usuario"></form>							
									<h5 style="color:black;">Artistas invitados de <%=nombre%></h5>
									<table class="table table-striped table-hover table-sm table-dark">
											<thead>
												<tr>
													<th scope="col">#</th>
												</tr>
											</thead>
											<tbody>
											  <%for (String s : invitados) { %>
												<tr><td>										
													<input type="button" class="btn-dark" name="bt" value="<%=s%>" onclick="{document.frm.usuario.value=this.value;document.frm.submit();}"/>
												</td></tr>
												<% } %>
											</tbody>
									</table>
							</div>								
	  					</div>
	  				</div> 				
				</div>
			</div>
	  	</div>	
  	</div>
			
	<%@include file="/footer.jsp" %>
</body>
</html>