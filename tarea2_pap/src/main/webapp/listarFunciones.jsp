<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/header.jsp" %>
<title>Funciones</title>
</head>
<body>		
	<%
	String nomEspec = (String) request.getAttribute("espectaculo");
	ArrayList<String> funciones = (ArrayList<String>)request.getAttribute("funciones");
	%>
	<div class="fondo">
		<div class="container">
			<div class="row">
				<div class="col-4"></div>
				<form action="InfoFuncion" name="frm" method="post" class="col-5">
					<input type="hidden" name="auxFunc">
					<h1 style="color:white;">Funciones de <%=nomEspec%></h1>
					<table class="table table-striped table-hover table-sm table-dark">
						<thead>
							<tr>
								<th scope="col">#</th>
							</tr>
						</thead>
						<tbody>
							<% for (String s : funciones) {	%>
							<tr>
							<td>
								<input type="button" class="btn-dark" name="bt" value="<%=s%>" onclick="{document.frm.auxFunc.value=this.value;document.frm.submit();}" />
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