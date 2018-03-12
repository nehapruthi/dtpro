<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ include file="templates/header.jsp" %>

<div class="container">
	<h2>Category Available</h2>
	<table class="table">
		<thead>
			<tr>
				<th>S No.</th>
				<th>Name</th>
				<th>Action</th>
			</tr>
			</thead>
		<tbody>
			<c:forEach items="${catList}" var="c" varStatus="s">
			<tr>
				<td>${s.count}</td>
				<td>${c.cName}</td>
				<td>
					<a href="/dtpro/admin/updateCategory/${c.cId}" class="btn btn-success">Update</button>
					<a href="/dtpro/admin/deleteCategory/${c.cId}" class="btn btn-danger">Delete</a>
				</td>
			</tr>
			</c:forEach>		
		</tbody>
	</table>
</div>
<%@ include file="templates/footer.jsp" %>