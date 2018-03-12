<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ include file="templates/header.jsp" %>


	<div class="container">
  <h2>Available Products</h2>           
  <table class="table">
    <thead>
      <tr>
        <th>S. no</th>
        <th>Image</th>
        <th>Product name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Description</th>
        <th>Category</th>
        <th>Action</th>
      </tr>
    </thead>
    
    <tbody>
    	<c:forEach items="${prodList}" var="p" varStatus="s">
      <tr>
        <td>${s.count}</td>
        <td><img src="${pageContext.request.contextPath}/Resources/images/${p.pImg}" alt=${pro.pImg } class="img-responsive" width="45" height="70"></td>
        <td>${p.pName}</td>
        <td>${p.pQuantity}</td>
        <td>${p.pPrice}</td>
        <td>${p.pDescription}</td>
        <td>${p.category.cName}</td>
        <td>
        	<a href="/dtpro/admin/updateProduct/${p.pId}" class="btn btn-success">Update</a>
        	<a href="/dtpro/admin/deleteProduct/${p.pId}" class="btn btn-danger">Delete</a>
        </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="templates/footer.jsp" %>