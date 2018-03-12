<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file = "templates/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      <div class="container">
  <form:form action="${pageContext.request.contextPath}/admin/updateCategory" modelAttribute="cat" method="post">
  <form:input path="cId" type="hidden"/>
    <div class="form-group">
      <label for="email">Category Name:</label>
      <form:input path="cName" type="text" class="form-control" id="email" placeholder="category name"/>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>
<%@ include file = "templates/footer.jsp" %>     
