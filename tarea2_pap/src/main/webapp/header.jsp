<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<% HttpSession sesion = request.getSession();
   String tipo = (String) sesion.getAttribute("tipoSesion");
   String nick = (String) sesion.getAttribute("nick");
   String imagenPerfil = (String) sesion.getAttribute("imagenPerfil");
%>
	   
   	<!-- Bootstrap core CSS -->
	<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    
    <link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.0/font/bootstrap-icons.css">
	<link rel="icon" href="https://i.imgur.com/qCwSbai.png">
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&family=Patrick+Hand&family=Josefin+Slab&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Maven+Pro&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Georama:ital,wght@1,300&family=Merriweather:wght@300&display=swap" rel="stylesheet">	
	
	<style>
		h1,h2,h3,h4,h5 {
			font-family: 'Maven Pro', sans-serif;
			text-align: center;
			color: white;	
		}
		
		a {font-family: 'Maven Pro', sans-serif;}
		span {font-family: "Maven Pro", cursive;}
		
		body, p {font-family: "Maven Pro", sans-serif;}	
		
	</style>
	
	<nav class="navbar navbar-dark bg-dark justify-content-center"> 
		<nav class="navbar navbar-expand-lg">
    		<a class="navbar-brand" href="index.jsp">coronaTickets</a>
    		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      			<span class="navbar-toggler-icon"></span>
    		</button>
    
		   <% if (tipo == null) { %>
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    	<form class="d-flex" action="ListarUsuarios" name="listarUsuario" method="post">
			     	 	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			       			<li class="nav-item dropdown">
			         			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Visitante</a>
			           			  <ul class="dropdown-menu" aria-labelledby="navbarDropdown">	          
					           	 	 <li>
					           			<a class="dropdown-item" onclick="{document.listarUsuario.submit();}">Consulta usuario</a>
					           		</li>  		 
					           	</ul>
					     </ul>  				     
					</form>
	  
			     <form class="d-flex" action="ListarEspectaculos" name="listarEspec" method="post">
				      <input type="hidden" name="aux">
				      <input class="form-control me-2" type="search" placeholder="Ingrese plataforma..." aria-label="Search" id="plataforma" name="plataforma">  
			     </form>
     			 <form action="ListarPaquetes" name="listarPaq" method="post"></form>
			     <ul class="navbar-nav me-auto mb-0 ml-4 mb-lg-0">		
			     	<li>     
			     	 	<button class="btn btn-outline-success" name="botonEspec" type="submit" value="e" onclick="{document.listarEspec.aux.value=this.value;document.listarEspec.submit();}" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Espectaculos"><i class="bi bi-image-fill"></i></button>      
			   			<button class="btn btn-outline-success" name="botonFunc" type="submit" value="f" onclick="{document.listarEspec.aux.value=this.value;document.listarEspec.submit();}" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Funciones"><i class="bi bi-shop-window"></i></button>	      
			     	    <button class="btn btn-outline-success" name="botonPaq" onclick="{document.listarPaq.submit();}" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Paquetes"><i class="bi bi-wallet-fill"></i></button>
				        <a class="btn btn-outline-success" role="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasWithBackdrop" aria-controls="offcanvasWithBackdrop">Iniciar sesión</a>
				        <a class="btn btn-outline-success" href="altaUsuario.jsp" role="button">Registrarse</a>
				  	</li> 
				   </ul>	       
		      </div> 	    
	    <% } else if (tipo.equals("espectador")) { %>
			    <form class="d-flex" action="ListarUsuarios" name="listarUsuario" method="post"></form> 
			    	<ul class="navbar-nav me-auto mb-2 mb-lg-0">	        
			        	<li class="nav-item dropdown">
			         		<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Espectador</a>
			         		<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					       		<li><a class="dropdown-item" onclick="{document.listarUsuario.submit();}">Consulta usuario</a></li>
					            <li><a class="dropdown-item" href="seguirUsuario.jsp">Seguir usuario</a></li>
					            <li><a class="dropdown-item" href="dejarSeguirUsuario.jsp">Dejar de seguir usuario</a></li>
			         	   </ul>
			       	  </li>
			        
				      <li class="nav-item dropdown">
				          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Función</a>
				          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				            <li><a class="dropdown-item" href="buscarPlataforma.jsp">Registro a función de espectáculo</a></li>
				          </ul>
				      </li>
		        
				      <li class="nav-item dropdown">
				      	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Paquete</a>
				        <form action="ListarPaquetesVigentes" name="comprarPaquete" method="post"></form> 
				        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				          	<li><a class="dropdown-item" onclick="{document.comprarPaquete.submit();}">Comprar paquete</a></li>
				        </ul>
				      </li>	        
		     	 </ul>
		     
			     <form class="d-flex" action="ListarEspectaculos" name="listarEspec" method="post">
				      <input type="hidden" name="aux">
				      <input class="form-control me-2" type="search" placeholder="Ingrese plataforma..." aria-label="Search" id="plataforma" name="plataforma">  
			      </form>	      
			      <form action="ListarPaquetes" name="listarPaq" method="post"></form>
			      <ul class="navbar-nav me-auto mb-0 ml-4 mb-lg-0">		
				     	<li> 
					      <button class="btn btn-outline-success" name="botonEspec" type="submit" value="e" onclick="{document.listarEspec.aux.value=this.value;document.listarEspec.submit();}" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Espectaculos"><i class="bi bi-image-fill"></i></button>
					      <button class="btn btn-outline-success" name="botonFunc" type="submit" value="f" onclick="{document.listarEspec.aux.value=this.value;document.listarEspec.submit();}" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Funciones"><i class="bi bi-shop-window"></i></button>
					      <button class="btn btn-outline-success" name="botonPaq" onclick="{document.listarPaq.submit();}" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Paquetes"><i class="bi bi-wallet-fill"></i></button> 	 
					      <form action="CerrarSesion" name="cerrarSesion" method="post"></form> 
					      <form class="d-flex" action="MostrarDatosUsuario" name="mostrarDatosUser" method="post"></form>
					    </li>
				 </ul>			      
			     <div class="row g-0">	     	
				      <div class="col-1"></div>	      	
				      <div class="col-2">
					     <% if (imagenPerfil != null) { %>
					     	<div><img src="data:image/jpg;base64,<%=imagenPerfil%>" width="48" height="48" id="circle"></div>					      
						<% } else { %>
							 <div><img src="imagenes/userPlaceholder3.png" id="circle"></div>
						<% } %>
					  </div>
					  <div class="col-2 mt-2">
					  	 <ul>
					    	<li class="nav-item dropdown">
				          		<a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"><%=nick%></a>
				         	    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						            <li><a class="dropdown-item" onclick="{document.mostrarDatosUser.submit();}">Modificar usuario</a></li>
						            <li><a class="dropdown-item" onclick="{document.cerrarSesion.submit();}">Cerrar sesión</a></li>				            
				         		</ul>
				       	 	</li>	        
				      	</ul>
				    </div>
		   		</div>	    
		   		
	    <% } else if (tipo.equals("artista")) { %>
	    	<div class="collapse navbar-collapse" id="navbarSupportedContent">
	    		<form class="d-flex" action="ListarEspectaculosDeArtista" name="altaFuncion" method="post"></form>	
	    		<form class="d-flex" action="ListarPaquetesEspectaculo" name="altaPaquete" method="post"></form>		    	
	    			    	
		    	<form class="d-flex" action="ListarUsuarios" name="listarUsuario" method="post">	
		    	    
		      		<ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        		<li class="nav-item dropdown">
			          		<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Artista</a>
			         		<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					            <li><a class="dropdown-item" onclick="{document.listarUsuario.submit();}">Consulta usuario</a></li>
					            <li><a class="dropdown-item" href="seguirUsuario.jsp">Seguir Usuario</a></li>
					            <li><a class="dropdown-item" href="dejarSeguirUsuario.jsp">Dejar de seguir usuario</a></li>
			         		</ul>
		       		   </li>
				       <li class="nav-item dropdown">
				          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Espectáculo</a>
				          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				         	 <li><a class="dropdown-item" href="altaEspectaculo.jsp">Alta espectáculo</a></li>
				          </ul>
				       </li>
				       	        
				        <li class="nav-item dropdown">
				          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Función</a>
				          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				          	<li><a class="dropdown-item" onclick="{document.altaFuncion.submit();}">Alta función de espectáculo</a></li>
				          </ul>
				        </li>
		        
				        <li class="nav-item dropdown">
				          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Paquete</a>
				          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				            <li><a class="dropdown-item" href="crearPaquete.jsp">Crear paquete de espectáculo</a></li>
				            <li><a class="dropdown-item" onclick="{document.altaPaquete.submit();}">Agregar espectáculo a paquete</a></li>
				          </ul>
				        </li>	        
				      </ul>
		      </form>
	      
		      <form class="d-flex" action="ListarEspectaculos" name="listarEspec" method="post">
			      <input type="hidden" name="aux">
			      <input class="form-control me-2" type="search" placeholder="Ingrese plataforma..." aria-label="Search" id="plataforma" name="plataforma">  
		      </form>
	      
		      <form action="ListarPaquetes" name="listarPaq" method="post"></form>
		      <ul class="navbar-nav me-auto mb-0 ml-4 mb-lg-0">		
			     	<li>
				      <button class="btn btn-outline-success" name="botonEspec" type="submit" value="e" onclick="{document.listarEspec.aux.value=this.value;document.listarEspec.submit();}" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Espectaculos"><i class="bi bi-image-fill"></i></button>
				      <button class="btn btn-outline-success" name="botonFunc" type="submit" value="f" onclick="{document.listarEspec.aux.value=this.value;document.listarEspec.submit();}" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Funciones"><i class="bi bi-shop-window"></i></button>
				      <button class="btn btn-outline-success" name="botonPaq" onclick="{document.listarPaq.submit();}" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Paquetes"><i class="bi bi-wallet-fill"></i></button> 
				    </li> 
			   </ul>
		      <form action="CerrarSesion" name="cerrarSesion" method="post"></form>
	     	  <form class="d-flex" action="MostrarDatosUsuario" name="mostrarDatosUser" method="post"></form>	      	
		      <div class="row g-0">
		      	  <div class="col-1"></div>	      	
		      	  <div class="col-2">
				  <% if (imagenPerfil != null) { %>
				     	<div><img src="data:image/jpg;base64,<%=imagenPerfil%>" width="48" height="48" id="circle"></div>					      
				<% } else { %>
						<div><img src="imagenes/userPlaceholder3.png" id="circle"></div>
				<% } %>
			     </div>
			     <div class="col-2 mt-2">
				 	<ul>
				    	<li class="nav-item dropdown">
			            	<a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"><%=nick%></a>
			          		<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				            	<li><a class="dropdown-item" onclick="{document.mostrarDatosUser.submit();}">Modificar usuario</a></li>
				            	<li><a class="dropdown-item" onclick="{document.cerrarSesion.submit();}">Cerrar sesión</a></li>
				            </ul>
			       		</li>	        
			      	</ul>
			     </div>
		      </div>			    
	     </div>
    <% } %>	    
	</nav>
  </nav>

<style>	
   	#circle {
	  border-radius: 50%;		  
	  object-fit: cover;
	}
   	
     .bd-placeholder-img {
       font-size: 1.125rem;
       text-anchor: middle;
       -webkit-user-select: none;
       -moz-user-select: none;
       user-select: none;
     }

     @media (min-width: 768px) {
       .bd-placeholder-img-lg {
         font-size: 3.5rem;
       }
     }
   
    
	.form-signin {
	  width: 100%;
	  max-width: 330px;
	  padding: 15px;
	  margin: auto;
	}
	
	.form-signin .form-floating:focus-within {
	  z-index: 2;
	}
	
	.form-signin input[type="email"] {
	  margin-bottom: -1px;
	  border-bottom-right-radius: 0;
	  border-bottom-left-radius: 0;
	}
	
	.form-signin input[type="password"] {
	  margin-bottom: 10px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
</style>

<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasWithBackdrop" aria-labelledby="offcanvasWithBackdropLabel">
	  <div class="offcanvas-header">
	    <h5 class="offcanvas-title" id="offcanvasWithBackdropLabel" style="color:black;">Iniciar Sesión</h5>
	    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
	  </div>
	  <div class="offcanvas-body">
	    <main class="form-signin">
		  <form action="InicioSesion" name="inicio" method="post">
		    <img class="mb-4 center" src="imagenes/coronaticketsUY.jpg" alt="" width="300" height="149">
		    <h1 class="h3 mb-3 fw-normal">Ingrese sus datos</h1>
		
		    <div class="form-floating">
		      <input class="form-control" id="floatingInput" name="nickMail" required>
		      <label for="floatingInput">Nick o mail</label>
		    </div>
		    <div class="form-floating">
		      <input type="password" class="form-control" id="floatingPassword" name="pass" required>
		      <label for="floatingPassword">Contraseña</label>
		    </div>
		
		    <button class="w-100 btn btn-lg btn-primary" type="submit">Ingresar</button>
		    <p class="mt-5 mb-3 text-muted">&copy; Developed by MCNC 2021</p>
		  </form>
		</main>
	  </div>
	</div>