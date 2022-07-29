<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Página principal</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="fondo">	
		<div class="alert alert-dark" role="alert">
		  <div>
		    ${mensaje}
		  </div>
		</div>				  		
 		
		<div class="logo-animado">
			<h1>CORONATICKETS</h1>		
		</div> 	 			
	</div>
	<%@include file="/footer.jsp" %>
</body>
</html>
