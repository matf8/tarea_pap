 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
	<% String usuario = (String)sesion.getAttribute("nick");
	if (usuario != null) { %>	
		<title> <%=usuario%> | Social </title>
	<% } %>	 
</head>
<body>
	<div class="fondo">	
		<div class="container">
	  		<div class="row">	  			
	  			<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 
	  			<div class="col-4"></div>
				<div class="wrap-contact3">
					<h3 style="text-align:center;"><%=usuario%></h3>
					<form action="SeguirUsuario" method="post" class="contact3-form validate-form">
						<h1 style="text-align:center"> Seguir usuario </h1>		
						
						<div class="wrap-input3 validate-input" data-validate="">
							<input class="input3" type="text" name="nick" placeholder="Nickname" required>
							<span class="focus-input3"></span>
						</div>	
						
						<div class="container-contact3-form-btn">
							<button type="submit" class="contact3-form-btn col-5 mx-auto" style="text-align:center;"> Seguir </button>
						</div>						
					</form>
				</div>
			</div>
		</div>
	</div>		

	<%@include file="/footer.jsp" %>
</body>
</html>
