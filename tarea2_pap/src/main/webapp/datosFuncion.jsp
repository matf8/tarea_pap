<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="datatypes.DtRegistroCompleto" %>
 
<!DOCTYPE html>
<html>
<head>
	<%@include file="/header.jsp" %>
	<title>Mostrar datos función</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<% 
	String nombre = (String) request.getAttribute("nombreF");
	String fecha = (String) request.getAttribute("fecha");
	String hora = (String) request.getAttribute("hora");
	ArrayList<DtRegistroCompleto> registros = (ArrayList<DtRegistroCompleto>) request.getAttribute("registros");
	String nickname = (String) sesion.getAttribute("nick");	
	String espectaculo = (String) request.getAttribute("espectaculo");
	ArrayList<String> paquetes = (ArrayList<String>) request.getAttribute("paquetes");	
	%>
	<div class="fondo">	
		<div class="container">
	  		<div class="row">	  
	  			<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 		
				<div class="container mt-5 bg-secondary bg-gradient text-white">
					<form action="RegistroFuncion" id="RegistroFuncion" method="post" class="row g-3">
						<input type="hidden" name="espectaculo" value="<%=espectaculo%>">					
						<div class="col-md-2">
						    <label for="validationDefaultUsername" class="form-label">Nombre función</label>
						    <div class="input-group">
						      <input type="text" class="form-control" id="validationDefaultUsername" name="nombreF" aria-describedby="inputGroupPrepend2" value="<%=nombre%>" readonly>
						    </div>
						</div>
				  	
					  <div class="col-md-4">
					    <label for="validationDefault02" class="form-label">Fecha</label>
					    <input type="date" class="form-control" id="validationDefault02" name="fecha" value="<%=fecha%>" readonly>
					  </div>
					  
					  <div class="col-md-2">
					    <label for="validationDefault02" class="form-label">Hora</label>
					    <input type="time" class="form-control" id="validationDefault02" name="hora" value="<%=hora%>" readonly>
					  </div>		
					
					  <div class="col-md-3">
						  <div class="wrap-input3 validate-input">	CANJEOS: Seleccione 3 registros para canjear 1 entrada gratis	
							<select name="registroElegido" form="CanjearRegistros" class="form-select" multiple aria-label="multiple select example">
								 <% if (registros != null) { 
									   for (DtRegistroCompleto r: registros) { %>	
								  	    	<option value="<%=r.getId()%>"><%=r%></option>
								  	 <% } 
								   } %>					
							</select>
						</div>						
					</div>		 
									
					<div class="col-md-3">
						<span class="contact3-form-title"> Paquetes disponibles de <%=nickname%></span>								
							<div class="wrap-input3 validate-input">	
								<select name="paqueteElegido" class="form-select" form="CanjearPaquete" required>										
								  	  <% if (paquetes != null && paquetes.size() != 0) {					      
									    	 for (String s: paquetes) { %>				      		     
									  	    	 <option value="<%=s%>"><%=s%></option>						 
									  <% } 
									  } else %> <option selected disabled value="">No hay paquetes disponibles</option>					  			
								</select>
							</div>		
					</div>		
						
					  <div class="col-md-12"> 
						<div class="col-12">
						   <button class="btn btn-danger" type="submit">Registrarse</button>
						 </div>	  
					  </div>
				  </form>
				  
				  <form action="CanjearPaquete" id="CanjearPaquete" name="CanjearPaquete" method="post" class="row g-1">
				  	<input type="hidden" name="nombreFuncion_Paquetes" value="<%=nombre%>">					
				    <input type="hidden" name="espectaculo_Paquetes" value="<%=espectaculo%>">					
				 </form>
				  
				  <div class="col-md-6"></div>	 
					<div class="col-12">
					   <button class="btn btn-danger" onclick="{document.CanjearPaquete.submit();}">Canjear paquete</button>
				    </div>
					
				<form action="CanjearRegistros" id="CanjearRegistros" name="CanjearRegistros" method="post" class="row g-1">
					<input type="hidden" name="nombreFuncion_Registros" value="<%=nombre%>">					
				    <input type="hidden" name="espectaculo_Registros" value="<%=espectaculo%>">
				</form>
				<div class="col-md-6"></div>	 
				  <div class="col-12">
				    <button class="btn btn-danger" onclick="{document.CanjearRegistros.submit();}">Canjear registros</button>
				  </div>			  
			
					<form action="buscarPlataforma.jsp" method="post" class="row g-1">
						<div class="col-md-6"></div>	 
						  <div class="col-12">
						    <button class="btn btn-danger" type="submit">Atrás</button>
						  </div>
					</form>		  
				</div>
			</div>
		</div>
	</div>
	<%@include file="/footer.jsp" %>
</body>
</html>