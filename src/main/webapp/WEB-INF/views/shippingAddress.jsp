    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <jsp:include page="/WEB-INF/views/templates/header.jsp"/>
<div class="container">
	<div class="row">
        <div class="span8">
        <h2>Add Shipping Address</h2>
        <c:if test="${msg}">
	        <div class="alert alert-danger">
			  <strong>Shipping Address not Available : </strong> Please add one shipping Address where the product will have to dispatched.
			</div>
		</c:if>
    		<form:form  modelAttribute="orders">
				<div class= "form-group">
				<label>Address : </label><br>
				<form:input path="sAddress.address" class="form-control" placeholder="Enter your Address"/>
				</div>
				<%-- <input type="hidden" name="cartItemId" value="${cartItemId}"/>
				 --%>
				<div class= "form-group">
				<label>City : </label><br>
				<form:input path="sAddress.city" class="form-control" placeholder="Enter your City"/>
				</div>
				<div class="form-group">
				<label>State : </label><br>
				<form:input path="sAddress.state" class="form-control" placeholder="Enter your State"></form:input>
				</div>
				<div class="form-group">
				<label>PinCode : </label><br>
				<form:input path="sAddress.pincode" class="form-control" placeholder="Enter your PinCode"></form:input>
				</div>
				<div class="checkbox">
				  <label><input type="checkbox" name="billingAddress" value="on">BillingAddress is same as ShippingAddress</label>
				</div>		
				<br><br>
				<button type="submit" value="Submit" name="_eventId_success" class="btn btn-lg btn-info">Submit</button>
				<button type="reset" value="Reset" class="btn btn-lg btn-info">Cancel</button>
				
				</form:form>

    	</div> <!-- .span8 -->
	</div>
</div>
<jsp:include page="/WEB-INF/views/templates/footer.jsp"/>