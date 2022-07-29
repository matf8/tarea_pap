<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Espectáculos</title>
</head>
<body>
	<%
	String nomPlat = (String) request.getAttribute("nomPlat");
	ArrayList<String> espectaculos = (ArrayList<String>)request.getAttribute("espectaculos");
	%>
	<div class="fondo">
		<div class="container">
			<div class="row">
				<div class="col-4"></div>
				<form action="ListarFunciones" name="frm" method="post" class="col-5">
					<input type="hidden" name="aux">
					<h1 style="color:white;">Espectaculos de <%=nomPlat%></h1>
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
								<input type="button" class="btn-dark" name="bt" value="<%=s%>" onclick="{document.frm.aux.value=this.value;document.frm.submit();}" />
							</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</form>
			</div>
		</div>	
	</div>
	<%@include file="/footer.jsp" %>
</body>
</html>