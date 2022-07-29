<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Paquete Información</title>
</head>
<body>		
	<%
	String nombre = (String) request.getAttribute("nombre");
	String descripcion = (String) request.getAttribute("descripcion");
	String fechaInicio = (String) request.getAttribute("fechaInicio");
	String fechaFin = (String) request.getAttribute("fechaFin");
	String fechaReg = (String) request.getAttribute("fechaReg");
	ArrayList<String> espectaculos = (ArrayList<String>)request.getAttribute("espectaculos");
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
				    <button class="nav-link active" style="color:black" id="datosPaquete" data-bs-toggle="tab" data-bs-target="#datos" type="button" role="tab" aria-controls="datos" aria-selected="true">Datos del paquete</button>
				    <button class="nav-link" id="e" style="color:black" data-bs-toggle="tab" data-bs-target="#espectaculos" type="button" role="tab" aria-controls="espectaculos" aria-selected="false">Espectaculos</button>
				  </div>
				</nav>
							
				<div class="tab-content" id="nav-tabContent">
				  <div class="tab-pane fade show active" id="datos" role="tabpanel" aria-labelledby="datosPaquete">
				  	
				  	<div class="card text-white bg-dark mb-3" style="max-width: 540px;">
						<div class="row g-0">
					    	<% if (imagen != null) { %>										
							    <div class="col-md-4">
							      <img src="data:image/jpg;base64,<%=imagen%>" class="img-fluid rounded-start" alt="...">
							    </div>
								<% } else { %>
								<div class="col-md-4">
							      <img src="imagenes/placeholderFoto2.jpg" class="img-fluid rounded-start" alt="...">
							    </div>									
							<% } %>
					    	<div class="col-md-8">
					      		<div class="card-body">
					       			<h5 class="card-title" style="color:white"><%=nombre%></h5>
							        <p class="card-text" style="color:white"><small>Descripcion: <%=descripcion%></small></p>
							        <p class="card-text" style="color:white"><small>Fecha inicio: <%=fechaInicio%></small></p>
							        <p class="card-text" style="color:white"><small>Fecha fin: <%=fechaFin%></small></p>
							        <p class="card-text" style="color:white"><small>Fecha de registro: <%=fechaReg%></small></p>
					     		</div>
					   		</div>
					   </div>
					</div>
				  </div>
				  
				<div class="tab-pane fade" id="espectaculos" role="tabpanel" aria-labelledby="e">				
					<div class="container col-8">
						<form action="InfoEspectaculo" name="frm" method="post">
							<input type="hidden" name="auxEspectaculo"></form>			
							<h5 style="color:black;">Espectaculos del paquete <%=nombre%></h5>
							<table class="table table-striped table-hover table-sm table-dark">
								<thead>
									<tr>
										<th scope="col">#</th>
									</tr>
								</thead>
								<tbody>
							       <%for (String s :espectaculos) { %>
									  <tr><td>										
										<input type="button" class="btn-dark" name="bt" value="<%=s%>" onclick="{document.frm.auxEspectaculo.value=this.value;document.frm.submit();}"/>
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