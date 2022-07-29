<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Usuario | Social </title>
</head>
<body>
	<% String usuario = (String) sesion.getAttribute("nick"); %>	
	<div class="fondo">	
		<div class="container">
	  		<div class="row">	  			
	  			<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 
	  			<div class="col-4"></div>
				<div class="wrap-contact3">
					<h4 style="text-align:center"><%=usuario%></h4>
					<form action="DejarSeguirUsuario" method="post" class="contact3-form validate-form">
						<h1 style="text-align:center">Deja de seguir </h1>						
						<div class="wrap-input3 validate-input" data-validate="">
							<input class="input3" type="text" name="nick" placeholder="Nickname" required>
							<span class="focus-input3"></span>
						</div>	
						
						<div class="container-contact3-form-btn">
							<button type="submit" class="contact3-form-btn col-6 mx-auto"> Dejar de seguir </button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/footer.jsp" %>
</body>
</html>
