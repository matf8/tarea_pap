<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Espectáculo | Información</title>
</head>
<body>
	<%
	String nombre = (String) request.getAttribute("nombre");
	String url = (String) request.getAttribute("url");
	String desc = (String) request.getAttribute("desc");
	Integer dur = (Integer) request.getAttribute("dur");
	Float costo = (Float) request.getAttribute("costo");
	ArrayList<String> funciones = (ArrayList<String>)request.getAttribute("funciones");
	ArrayList<String> paquetes = (ArrayList<String>)request.getAttribute("paquetes");
	String org = (String) request.getAttribute("org");
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
				 		 	 <button class="nav-link active" style="color:black" id="datosEspectaculo" data-bs-toggle="tab" data-bs-target="#datos" type="button" role="tab" aria-controls="datos" aria-selected="true">Datos del espectáculo</button>
				 		  	 <button class="nav-link" id="datosFuncion" style="color:black" data-bs-toggle="tab" data-bs-target="#funciones" type="button" role="tab" aria-controls="funciones" aria-selected="false">Funciones</button>
				 			 <button class="nav-link" id="datosPaquete" style="color:black" data-bs-toggle="tab" data-bs-target="#paquetes" type="button" role="tab" aria-controls="paquetes" aria-selected="false">Paquetes</button>				
				 		  </div>
	  				</nav>
				 	
				 	<div class="tab-content" id="nav-tabContent">
						<div class="tab-pane fade show active" id="datos" role="tabpanel" aria-labelledby="datosEspectaculo">
				  			<div class="container col-6">
								<div class="card text-white bg-dark mb-3" style="max-width: 870px;">
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
								        <h5 class="card-title" style="color:white"><%=org%> organiza</h5>
								        <p class="card-text text-center" style="color:white"><%=nombre%></p>							        
								        <p class="card-text" style="color:white"><%=desc%></p>
								        <p class="card-text text-white"><small>Url: <%=url%></small></p>
								        <p class="card-text"><small style="color:white">Duración: <%=dur%></small></p>
								        <p class="card-text" style="color:white"><small>Costo del espectaculo: <%=costo%></small></p>
								      </div>
								    </div>
								  </div>
								</div>
							</div>	
				  		</div>
				  		
				  		<div class="tab-pane fade" id="funciones" role="tabpanel" aria-labelledby="datosFuncion">			  
				  			<div class="container col-8">
								<form action="InfoFuncion" name="frmFunc" method="post">
									<input type="hidden" name="auxFunc">
										<h5 style="color:black">Funciones de <%=nombre%></h5>
											<table class="table table-striped table-hover table-sm table-dark">
											<thead>
												<tr><th scope="col">#</th>									</tr>
											</thead>
											<tbody>
											<% for (String s : funciones) {	%>
												<tr>
												<td>
													<input type="button" class="btn-dark" name="bt" value="<%=s%>" onclick="{document.frmFunc.auxFunc.value=this.value;document.frmFunc.submit();}" />
												</td>
												</tr>
											<% } %>
											</tbody>
									</table>
								</form>
							</div>
				  		</div>
				  		
				  		<div class="tab-pane fade" id="paquetes" role="tabpanel" aria-labelledby="p">
				  			<div class="container col-6">
								<form action="InfoPaquete" name="frmPaq" method="post">
									<input type="hidden" name="auxPaq">
										<h5 style="color:black;">Paquetes de <%=nombre%></h5>
										<table class="table table-striped table-hover table-sm table-dark">
											<thead>
												<tr>
													<th scope="col">#</th>
												</tr>
											</thead>
											<tbody>
												<% for (String s : paquetes) { %>
												<tr>
													<td>
														<input type="button" class="btn-dark" name="bt" value="<%=s%>" onclick="{document.frmPaq.auxPaq.value=this.value;document.frmPaq.submit();}" />
													</td>
												</tr>
												<% } %>
											</tbody>
										</table>
								</form>
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