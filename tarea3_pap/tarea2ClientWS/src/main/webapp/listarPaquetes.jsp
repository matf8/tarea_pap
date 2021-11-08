<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Lista de paquetes</title>
</head>
<body>		
	<% ArrayList<String> listaPaquetes = (ArrayList<String>)request.getAttribute("listaPaquetes"); %>
	<div class="fondo">
		<div class="container">
			<div class="row">
				<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 
	  			<div class="col-4"></div>
	  			<%if(detector.detectMobileQuick()){ %>  
					<form action="InfoPaquete" name="frm" method="post">
				<%}else{ %>
					<form action="InfoPaquete" name="frm" method="post" class="col-5">
				<%} %>
					<input type="hidden" name="auxPaq">
					<h1 style="color:white;">Paquetes disponibles</h1>
					<table class="table table-striped table-hover table-sm table-dark">
						<thead>
							<tr>
								<th scope="col">#</th>
							</tr>
						</thead>
						<tbody>
							<% for (String s : listaPaquetes) {	%>
							<tr>
								<td>
								<input type="button" class="btn-dark" name="bt" value="<%=s%>" onclick="{document.frm.auxPaq.value=this.value;document.frm.submit();}" />
								</td>
							</tr>
							<% } %>
						</tbody>
					</table>
					</form>
				</div>	
			</div>
		</div>				
	<%@include file="/footer.jsp" %>
</body>
</html>