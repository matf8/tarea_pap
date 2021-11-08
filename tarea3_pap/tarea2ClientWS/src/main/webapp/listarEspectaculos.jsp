<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Espectáculos</title>
</head>
<body>
	<% String nomPlat = (String) request.getAttribute("nomPlat");
	   ArrayList<String> espectaculos = (ArrayList<String>)request.getAttribute("espectaculos"); %>
	<div class="fondo">
		<div class="container">
			<div class="row">
				<div class="container mt-4"> </div> 	
	  			<div class="container mt-4"> </div> 
				<div class="col-4"></div>
				<%if(detector.detectMobileQuick()){ %>  
					<form action="InfoEspectaculo" name="frm" method="post">
				<%}else{ %>
					<form action="InfoEspectaculo" name="frm" method="post" class="col-5">
				<%} %>
					<input type="hidden" name="auxEspectaculo">
					<div class="col-md-12">
						<h1 style="color:white;">Espectáculos de <%=nomPlat%></h1>
						<table class="table table-striped table-hover table-sm table-dark">
							<thead>
								<tr>
									<th scope="col">#</th>
								</tr>
							</thead>
							<tbody>
								<% for (String s : espectaculos) { %>
								<tr>
								<td>
									<input type="button" class="btn-dark" name="bt" value="<%=s%>" onclick="{document.frm.auxEspectaculo.value=this.value;document.frm.submit();}" />
								</td>
								</tr>
								<%
								   }
								%>
							</tbody>
						</table>
					</div>
				</form>
			</div>
		</div>			
	</div>
	<%@include file="/footer.jsp" %>
</body>
</html>