    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ include file = "templates/header.jsp" %>

      <div class="container">
  <form:form action="${pageContext.request.contextPath}/admin/updateSupplier" modelAttribute="sup" method="post">
  <form:input path="sId" type="hidden"/>
    <div class="form-group">
      <label for="email">Supplier Name:</label>
      <form:input path="sName" type="text" class="form-control" id="email" placeholder="supplier name"/>
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>
<%@ include file = "templates/footer.jsp" %>     
