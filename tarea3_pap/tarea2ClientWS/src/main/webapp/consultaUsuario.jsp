<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/header.jsp" %>
	<% String usuario = (String) sesion.getAttribute("nick");
	   if (usuario == null)
		   usuario = "Visitante"; %>		
	<title><%=usuario%> | Consulta </title>
</head>
<body>
	<div class="fondo">
		<div class="container">
			<div class="row">
				<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 
				<div class="col-4"></div>
				<div class="wrap-contact3">
					<h3 style="text-align:center"><%=usuario%></h3>
					<form action="PerfilUsuario" method="post" class="contact3-form validate-form">
						<h1 style="text-align:center">Lista de usuarios</h1>	
						<% ArrayList<String> usuarios = (ArrayList<String>)request.getAttribute("listaUsuarios"); %>						
						<div class="wrap-input3 validate-input mt-4">
							<select class="form-select" name="usuario" aria-label="Default select example" required>	
								<option selected disabled value="">Seleccione un usuario</option>			
								<% if (usuarios != null) {
									for (String u: usuarios) { %>
							  			<option value="<%=u%>"><%=u%></option>
								<% }
								} %>
							</select>	
						</div>				
						 <div class="container-contact3-form-btn">
							<button type="submit" class="contact3-form-btn col-4 mx-auto">Seleccionar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>		
	<%@include file="/footer.jsp" %>
</body>
</html>
