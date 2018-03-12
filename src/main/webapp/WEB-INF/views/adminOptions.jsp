<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file = "templates/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p class="lead">Welcome ${pageContext.request.userPrincipal.name}!!</p>
<h4>Options available:</h4>
  <div class="list-group">
    <a href="/dtpro/listProducts" class="list-group-item"><span class="glyphicon glyphicon-th-list"></span>  List all products</a>
    <security:authorize access="hasRole('ROLE_ADMIN')">
    <a href="/dtpro/admin/addProduct" class="list-group-item"><span class="glyphicon glyphicon-plus"></span>  Add product</a>
    </security:authorize>
    <a href="/dtpro/admin/showProducts" class="list-group-item"><span class="glyphicon glyphicon-pencil"></span>  Update/Delete Product</a>
    <security:authorize access="hasRole('ROLE_ADMIN')">
    <a href="/dtpro/admin/addCategory" class="list-group-item"><span class="glyphicon glyphicon-plus"></span>  Add category</a>
    </security:authorize>
    <a href="/dtpro/admin/showCategory" class="list-group-item"><span class="glyphicon glyphicon-pencil"></span>  Update/Delete Category</a>
    <security:authorize access="hasRole('ROLE_ADMIN')">
    <a href="/dtpro/admin/addSupplier" class="list-group-item"><span class="glyphicon glyphicon-plus"></span>  Add supplier</a>
    </security:authorize>
    <a href="/dtpro/admin/showSuppliers" class="list-group-item"><span class="glyphicon glyphicon-pencil"></span>  Update/Delete Supplier</a>
  </div>

<%@ include file = "templates/footer.jsp" %>