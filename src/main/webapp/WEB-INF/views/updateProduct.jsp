<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ include file = "templates/header.jsp" %>
<div class="container">
<form:form action="${pageContext.request.contextPath}/admin/updateProduct" modelAttribute="pro" enctype="multipart/form-data">


      <form:input path="pId" type="hidden" class="form-control"></form:input>
   
    <div class="form-group">
      <label for="email">Product Name:</label>
      <form:input path="pName" type="text" class="form-control" id="email" placeholder="product name"/>
    </div>
    <div class="form-group">
      <label for="email">Product Quantity:</label>
      <form:input path="pQuantity" type="number" class="form-control" id="email" placeholder="Quantity"/>
    </div>
    <div class="form-group">
      <label for="email">Product Price:</label>
      <form:input path="pPrice" type="number" class="form-control" id="email" placeholder="price"/>
    </div>
    <div class="form-group">
      <label for="email">Product Description:</label>
      <form:input path="pDescription" type="text" class="form-control" id="email" placeholder="Description"/>
    </div>
    
    <div class="form-group">
	  <label for="sel1">Select Category:</label>
	  <form:select path="category.cId" class="form-control" id="sel1" >
	  <form:option value="0">---choose Category---</form:option>
	  	<form:options items="${catList}" itemValue="cId" itemLabel="cName" />
	  </form:select>
	</div>
	<div class="form-group">
	  <label for="sel1">Select Supplier:</label>
	  <form:select path="supplier.sId" class="form-control" id="sel1" >
	  <form:option value="0">---choose Supplier---</form:option>
	  	<form:options items="${supList}" itemValue="sId" itemLabel="sName" />
	  </form:select>
	</div>

	<div class="form-group">
      <label for="email">Product Picture:</label>
      <input type="file" class="form-control" id="email" placeholder="image name" name="pfile"/>
    </div>

    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>
 <%@ include file = "templates/footer.jsp" %>     
