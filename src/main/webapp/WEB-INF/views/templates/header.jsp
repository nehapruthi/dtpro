<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body">



<nav class="navbar navbar-inverse">
    <ul class="nav navbar-nav navbar-right">
     <c:if test="${pageContext.request.userPrincipal.name==null }">
      <li><a href="registerUser"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name!=null }">
      <li><a href="/dtpro/userProfile"><span class="glyphicon glyphicon-user"></span>Welcome ${pageContext.request.userPrincipal.name}</a></li>
      <li><a href="/dtpro/cart"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
      <li><a href="<c:url value="/j_spring_security_logout"/>"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </c:if>
    </ul>
    </nav>
   
    	<div class="container">
    		<%@ include file = "homepage.jsp" %>
    	</div>
    	
     <br><br>
    
    <!--  Navigations -->
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav" style="text-align: center;">
      <li><a href="/dtpro/"><span class="glyphicon glyphicon-home"></span> Home</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-info-sign"></span> About Us</a></li>
      <li><a href="/dtpro/"><span class="glyphicon glyphicon-bell"></span> Notifications</a></li>
      <security:authorize access="hasRole('ROLE_ADMIN')">
       <li><a href="/dtpro/admin/adminOptions"><span class="glyphicon glyphicon-user"></span> Administrator Tasks</a></li>
       </security:authorize>
       <li><a href="/dtpro/listProducts"><span class="glyphicon glyphicon-tag"></span> Products Available</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-earphone"></span> Contact Us</a></li>
    </ul>
  </div>
</nav>
    

  
<div class="container">
  </div>



  
<div class="container">
  </div>


