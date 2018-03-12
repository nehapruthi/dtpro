<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file = "templates/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

		<!-- Website CSS style -->
		<link rel="stylesheet" type="text/css" href="assets/css/main.css">

		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

		<!-- <title>Admin</title> -->
<style>
	.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
	<div class="container">
		<form:form action="saveUser" modelAttribute="user" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="email">User Name:</label>
      <form:errors path="uName" cssClass="error" id="name" element="span"></form:errors>
      <span class="error">Name is required</span>
      <form:input path="uName" type="text" class="form-control" id="name" placeholder="user name"/>
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <form:errors path="email" cssClass="error" id="email" element="span"></form:errors>
      <span class="error">Email is required</span>
      <form:input path="email" type="text" class="form-control" id="email" placeholder="enter your email"/>
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <form:errors path="password" cssClass="error" id="pass" element="span"></form:errors>
      <span class="error">Password is required</span>
      <form:input path="password" type="password" class="form-control" id="pass" placeholder="enter your password"/>
    </div>
    <div class="form-group">
      <label for="address">Address</label>
      <form:errors path="address" cssClass="error" id="address" element="span"></form:errors>
      <span class="error">Address is required</span>
      <form:input path="address" type="text" class="form-control" id="address" placeholder="specify your address"/>
    </div>
    <div class="form-group">
      <label for="role">Role</label>
      <form:errors path="role" cssClass="error" id="role" element="span"></form:errors>
   	<span class="error">Role is required</span>
      <form:input path="role" type="text" class="form-control" id="role" placeholder="specify your role"/>
    </div>
    
    <div class="form-group">
      <label for="phone">Phone</label>
      <form:errors path="phone" cssClass="error" id="phone" element="span"></form:errors>
      <span class="error">Phone is required</span>
      <form:input path="phone" type="text" class="form-control" id="phone" placeholder="enter contact number"/>
    </div>
    
    
	<div class="form-group">
      <label for="image">User Profile Picture:</label>
      <form:input path="pFile" type="file" class="form-control" id="image" placeholder="image name"/>
    </div> 

    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>

	</body>
</html>
<%@ include file = "templates/footer.jsp" %>