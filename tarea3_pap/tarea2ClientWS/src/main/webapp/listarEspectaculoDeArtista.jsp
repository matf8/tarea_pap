<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/header.jsp" %>
	<title>Alta | Funci�n</title>
</head>
<body>
	<% String usuario = (String)sesion.getAttribute("nick"); %>
	<div style="margin: auto; width:30%; padding-top:50px">
		<h4 style="text-align:center"><%=usuario %></h4>
		<form action="ListarEspectaculosDeArtista" method="post">
			<div class="container-contact3-form-btn">		
				<p align="center"><button type="submit" class="contact3-form-btn">
					Mostrar tus espect�culos</button></p>
			</div>			
		</form>
	</div>	
	<%@include file="/footer.jsp" %>
</body>
</html>