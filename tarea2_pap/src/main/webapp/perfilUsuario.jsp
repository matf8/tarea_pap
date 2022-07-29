<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="datatypes.DtFuncion" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<%  String nickname = (String) request.getAttribute("nick");
	if (nickname != null) { %>
		<title> <%=nickname%> | Perfil </title>
	<%} else {%> 
		<title> Visitante | Perfil </title>
	<% } %>
</head>
 <% List<String> seguidores =  (List<String>)request.getAttribute("listaSeguidores"); 
 	List<String> seguidos =  (List<String>)request.getAttribute("listaSeguidos");
	List<DtFuncion> registros = (List<DtFuncion>)request.getAttribute("registro_funciones");    
 
 	String flag = (String) request.getAttribute("flag");  
 
 	//String nickname = (String) request.getAttribute("nick");
	String nombre = (String) request.getAttribute("nombre");
	String apellido = (String) request.getAttribute("apellido");
	String fnac = (String) request.getAttribute("fnac");
	String mail = (String) request.getAttribute("correo");
	String desc = (String) request.getAttribute("descripcion");
	String url = (String) request.getAttribute("url");
	String bio = (String) request.getAttribute("bio");	
	String imagen = (String) request.getAttribute("imagen");
	
	int iseguidores = seguidores.size();
	int iseguidos = seguidos.size();
	
  %>
  <div class="fondo">	
		<div class="container">
	  		<div class="row">	  			
	  			<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div>  
					<div class="container col-5 bg-secondary bg-gradient text-black">
					  <nav>
						  <div class="nav nav-tabs" id="nav-tab" role="tablist">
						    <button class="nav-link active" style="color:black" id="datosUsuario" data-bs-toggle="tab" data-bs-target="#datos" type="button" role="tab" aria-controls="datos" aria-selected="true">Datos del usuario</button>
						    <button class="nav-link" id="social" style="color:black" data-bs-toggle="tab" data-bs-target="#seguidores" type="button" role="tab" aria-controls="seguidores" aria-selected="false">Seguidores</button>
						    <% 
							if (flag.equals("mostrarPaquetes")) { %>					
								<button class="nav-link" id="p" style="color:black" data-bs-toggle="tab" data-bs-target="#paquetes" type="button" role="tab" aria-controls="paquetes" aria-selected="false">Paquetes</button>				
							<%} 	
						    if (flag.equals("A")) { %>
								<button class="nav-link" id="e" style="color:black" data-bs-toggle="tab" data-bs-target="#espectaculos" type="button" role="tab" aria-controls="espectaculos" aria-selected="false">Espectáculos</button>				
							<%} else { %>		    
								<button class="nav-link" id="registros" style="color:black" data-bs-toggle="tab" data-bs-target="#funciones" type="button" role="tab" aria-controls="funciones" aria-selected="false">Funciones</button>
							<%}	%>	
						  </div>
						</nav>
						<div class="tab-content" id="nav-tabContent">
						  <div class="tab-pane fade show active" id="datos" role="tabpanel" aria-labelledby="datosUsuario">
						  
						  	<div class="row">
									<div class="form-floating mb-2 col-sm-6">Nickname
									  <input type="text" class="form-control" id="nick" value="<%=nickname%>" disabled>
									  <label for="nick"></label>
									</div>
									<div class="form-floating mb-2 col-sm-6">E-mail
									  <input type="email" class="form-control" id="mail" value="<%=mail%>" disabled>
									  <label for="mail"></label>
									</div>
								</div>	
							
							<div class="row">	
								<div class="form-floating mb-2 col-sm-6">Nombre
								  <input type="text" class="form-control" id="nombre" value="<%=nombre%>" disabled>
								  <label for="nombre"></label>
								</div>
								<div class="form-floating mb-2 col-sm-6">Apellido
								  <input type="text" class="form-control" id="apellido" value="<%=apellido%>" disabled>
								  <label for="apellido"></label>
								</div>
							</div>	
								
							<div class="row">	
								<div class="form-floating form-floating mb-2 col-sm-6">Fecha de nacimiento
								  <input type="date" class="form-control" id="fnac" value="<%=fnac%>" disabled>
								  <label for="fnac"></label>
							</div>			
						<% if (!flag.equals("A")) { %>										
							<% if (imagen != null) { %>										
							    <div class="col-md-4">
							      <img src="data:image/jpg;base64,<%=imagen%>" class="img-fluid rounded-start" alt="...">
							    </div>
							<% } else { %>
								<div class="col-md-4">
							      <img src="imagenes/userPlaceholder.png" class="img-fluid rounded-start" alt="...">
							    </div>									
							<% } %>
						  <% } %>
						</div>				
										
						<% if (flag.equals("A")) { %>			
						    <div class="row">
								 <div class="form-floating mb-2 col-sm-6">Biografia
							 	 	 <input type="text" class="form-control" id="biografia" value="<%=bio%>" disabled>
							 		 <label for="biografia"></label>
								 </div>
								 <div class="form-floating mb-2 col-sm-6">Descripcion
							  		<input type="text" class="form-control" id="desc" value="<%=desc%>" disabled>
							 		 <label for="desc"></label>
								</div>
							</div>	
							
							<div class="row">	
								<div class="form-floating form-floating mb-2 col-sm-6">URL
							 		 <input type="text" class="form-control" id="url" value="<%=url%>" disabled>
							 		 <label for="url"></label>
								</div>	
									<% if (imagen != null) { %>										
									    <div class="col-md-4">
									      <img src="data:image/jpg;base64,<%=imagen%>" class="img-fluid rounded-start">
									    </div>
									<% } else { %>
										<div class="col-md-4">
									      <img src="imagenes/userPlaceholder.png" class="img-fluid rounded-start">
									    </div>									
									<% } %>
							</div>
						<% } %>										  	  
						 </div>	  	  
						  	  
						  	  
						  <div class="tab-pane fade" id="seguidores" role="tabpanel" aria-labelledby="social">
						  	<form action="PerfilUsuario" name="frm4" method="post">
								<input type="hidden" name="usuario"></form>								
								<table class="table table-striped table-hover table-sm table-dark" style="width:50%;float:left">
									<thead>
										<tr>
											<th scope="col">#	Seguidos  ~  <%=iseguidos%></th>
										</tr>
									</thead>
									<tbody>
										<% if (seguidos != null) {
											for (String k: seguidos) { %>													
										<tr>
										<td>
											<input type="button" class="btn-dark" name="bt" value="<%=k%>" onclick="{document.frm4.usuario.value=this.value;document.frm4.submit();}" />
										</td>
										</tr>
										 <% }
					        		  } %>
									</tbody>
								</table>								
								<table class="table table-striped table-hover table-sm table-dark" style="width:50%;float:left">
									<thead>
										<tr>
											<th scope="col">#	Seguidores  ~  <%=iseguidores%></th>
										</tr>
									</thead>
									<tbody>
										<% if (seguidores != null) {
											for (String k: seguidores) { %>													
										<tr>
										<td>
											<input type="button" class="btn-dark" name="bt" value="<%=k%>" onclick="{document.frm4.usuario.value=this.value;document.frm4.submit();}" />
										</td>
										</tr>
										 <% }
					        		  } %>
									</tbody>
								</table>						
						</div>
						   			   
						  <div class="tab-pane fade" id="funciones" role="tabpanel" aria-labelledby="registros">			  
							<%if (!flag.equals("A")) {%>		
								<div class="container">
									<form action="InfoFuncion" name="frm" method="post" class="col-5">
										<input type="hidden" name="auxFunc"></form>				
										<h1>Regitros a funciones de <%=nickname%></h1>
										<table class="table table-striped table-hover table-sm table-dark">
											<thead>
												<tr>
													<th scope="col">#</th>
												</tr>
											</thead>
											<tbody>
										    <% if (registros != null) {
											      for (DtFuncion s: registros) { %>
											         <tr><td>
														<input type="button" class="btn-dark" name="bt" value="<%=s.getNombre()%>" onclick="{document.frm.auxFunc.value=this.value;document.frm.submit();}"/>
												    </td></tr>
									   	      <% }
									        }%>					
									       </tbody>
									</table>
							</div>	
						  </div>
						  			  
						  <div class="tab-pane fade" id="paquetes" role="tabpanel" aria-labelledby="p">
						 <% }
							if (flag.equals("mostrarPaquetes")) {
						        List<String> paquetes = (List<String>)request.getAttribute("listaPaquetesEspectador");    %>
						        <div class="container">
									<form action="InfoPaquete" name="frm2" method="post" class="col-5">
										<input type="hidden" name="auxPaq"></form>
										<h1>Paquetes comprados de <%=nickname%></h1>
										<table class="table table-striped table-hover table-sm table-dark">
											<thead>
												<tr>
													<th scope="col">#</th>
												</tr>
											</thead>
											<tbody>		
											<% if (paquetes != null) {
											      for (String p: paquetes) { %>
													<tr><td>
														<input type="button" class="btn-dark" name="bt" value="<%=p%>" onclick="{document.frm2.auxPaq.value=this.value;document.frm2.submit();}" />
													</td></tr>
										     	<%}
											  }%>
										  </tbody>
									 </table>
								</div>
								<% } %>			  
						  </div>
						  
						  <div class="tab-pane fade" id="espectaculos" role="tabpanel" aria-labelledby="e"> 
							<% if (flag.equals("A")) { 
								List<String> espectaculos = (List<String>) request.getAttribute("espectaculos_organizados"); %>
						  		<div class="container">
									<form action="InfoEspectaculo" name="frm3" method="post" class="col-5">
										<input type="hidden" name="auxEspectaculo"></form>
										<h1>Espectaculos organizados de <%=nickname%></h1>
										<table class="table table-striped table-hover table-sm table-dark">
											<thead>
												<tr>
													<th scope="col">#</th>
												</tr>
											</thead>
											<tbody>		
											<% 		
											if (espectaculos != null) {
												for (String j: espectaculos) { %>
													<tr>
													<td>
														<input type="button" class="btn-dark" name="bt" value="<%=j%>" onclick="{document.frm3.auxEspectaculo.value=this.value;document.frm3.submit();}" />
													</td>
													</tr>
												<%}
											}%>
											</tbody>
										</table>
									</div>
								<%}%>			  
						   </div>
						</div>  
				 	 </div>  
				 </div>
			 </div>
	</div>
	
<%@include file="/footer.jsp" %>
</body>
</html>