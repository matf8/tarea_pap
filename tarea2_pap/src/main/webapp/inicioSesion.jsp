<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Inicio Sesion</title>
</head>
<body>
	<main class="form-signin">
	  <form action="InicioSesion" name="inicio" method="post">
	    <img class="mb-4 center" src="imagenes/coronaticketsUY.jpg" alt="" width="300" height="149">
	    <h1 class="h3 mb-3 fw-normal">Ingrese sus datos</h1>
	
	    <div class="form-floating">
	      <input class="form-control" id="floatingInput" name="nickMail" required>
	      <label for="floatingInput">Nick o mail</label>
	    </div>
	    <div class="form-floating">
	      <input type="password" class="form-control" id="floatingPassword" name="pass" placeholder="Contraseña" required>
	      <label for="floatingPassword">Contraseña</label>
	    </div>
	
	    <button class="w-100 btn btn-lg btn-primary" type="submit">Ingresar</button>
	    <p class="mt-5 mb-3 text-muted">&copy; 2021</p>
	  </form>
	</main>

<%@include file="/footer.jsp" %>
</body>
</html>