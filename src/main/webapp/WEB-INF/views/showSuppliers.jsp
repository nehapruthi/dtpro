<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ include file="templates/header.jsp" %>

<div class="container">
	<h2>Supplier Available</h2>
	<table class="table">
		<thead>
			<tr>
				<th>S No.</th>
				<th>Name</th>
				<th>Action</th>
			</tr>
			</thead>
		<tbody>
			<c:forEach items="${supList}" var="sup" varStatus="s">
			<tr>
				<td>${s.count}</td>
				<td>${sup.sName}</td>
				<td>
					<a href="/dtpro/admin/updateSupplier/${sup.sId}" class="btn btn-success">Update</button>
					<a href="/dtpro/admin/deleteSupplier/${sup.sId}" class="btn btn-danger">Delete</button>
				</td>
			</tr>
			</c:forEach>		
		</tbody>
	</table>
</div>
<%@ include file="templates/footer.jsp" %>