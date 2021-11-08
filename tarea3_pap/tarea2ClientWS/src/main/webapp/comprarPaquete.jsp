<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Paquete | Compra</title>
</head>
<body>

	<div class="fondo">
		<div class="container">
			<div class="row">
				<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 
				<div class="col-4"></div>				
					<div class="wrap-contact3">
						<form action="CompraPaquete" method="post" class="contact3-form validate-form">
							<span class="contact3-form-title">Compra Paquete</span>												
							<% ArrayList<String> paquetes = (ArrayList<String>)request.getAttribute("listaPaquetesVigentes");%>
							<div class="wrap-input3 validate-input">
								<select class="form-select" name="selectPaquete" aria-label="Default select example">
									<% if (paquetes != null)
										for (String s : paquetes) { %>
								  			<option value="<%=s%>"><%=s%></option>
									<% } %>
								</select>	
							</div>	
							        
							 <div class="text-white text-center" role="alert">
								  <div>
								    ${mensaje}
							 	 </div>
							</div>						           	    
		                	
							<div class="container-contact3-form-btn">
								<button type="submit" class="contact3-form-btn col-6 mx-auto">Comprar paquete</button>
							</div>						
						</form>			
				</div>
			</div>
		</div>	
	</div>
	<%@include file="/footer.jsp" %>
</body>
</html>