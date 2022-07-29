<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp" %>
<title>Registro | Función</title>
</head>
<body>
	<div class="fondo">
		<div class="container">
			<div class="row">
				<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 
				<div class="col-4"></div>
				<div class="wrap-contact3">
					<form action="MostrarPlataforma" method="post" class="contact3-form validate-form">
						<span class="contact3-form-title">Plataforma</span>			
							<div class="wrap-input3 validate-input" data-validate="">
								<input class="input3" type="text" name="nombrePlataforma" placeholder="Nombre de la plataforma" required>
								<span class="focus-input3"></span>
							</div>
						<div class="container-contact3-form-btn">
							<button type="submit" class="contact3-form-btn col-6 mx-auto">Siguiente</button>
						</div>						
					</form>			
				</div>
			</div>
		</div>	
	</div>
	
	<%@include file="/footer.jsp" %>
</body>
</html>