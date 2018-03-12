<jsp:include page="/WEB-INF/views/templates/header.jsp"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="container">
		<div class="row">
		<form:form modelAttribute="orders">
			<div class="col-xs-12">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title">
							<div class="row">
								<div class="col-xs-6">
									<h5><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>
								</div>
								<div class="col-xs-6">
									<button type="button" class="btn btn-primary btn-sm btn-block">
										<span class="glyphicon glyphicon-share-alt"></span> Continue shopping
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-xs-2"><img class="img-responsive" src="Resources/images/${orders.product.pImg}">
							</div>
							<div class="col-xs-4">
								<h4 class="product-name"><strong>${orders.product.pName }</strong></h4><h4><small>${orders.product.pDescription }</small></h4>
							</div>
							<div class="col-xs-6">
								<div class="col-xs-6 text-right">
									<h6><strong>${orders.product.pPrice } <span class="text-muted">x</span></strong></h6>
								</div>
								<div class="col-xs-4">
									<form:input path="cartItem.quantity" type="text" class="form-control input-sm" value="${cartItem.quantity }"></form:input>
								</div>
								<div class="col-xs-2">
									<button type="button" class="btn btn-link btn-xs">
										<span class="glyphicon glyphicon-trash"> </span>
									</button>
								</div>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-xs-12">
							<c:if test="${orders.bAddress.address eq null }">
								<div class="checkbox">
								  <label><input type="checkbox" name="billingAddress" value="on">BillingAddress is same as ShippingAddress</label>
								</div>
							</c:if>
									<c:forEach var="s" items="${orders.shippingAddressList}">
										<div class="well">
											<div class="radio">
											  <label><form:radiobutton path="sAddress.shippingId" value="${s.shippingId}"/></label>
											  <br>
											  	<strong>Address : </strong>${s.address }<br>
											  	<strong>City : </strong>${s.city }<br>
											  	<strong>State : </strong>${s.state }<br>
											  	<strong>PinCode : </strong>${s.pincode }
											  
											  </div>
										</div>
										<hr>
									</c:forEach>
							</div>
							</div>
						</div>
							
						
						<!-- <hr>
						<div class="row">
							<div class="text-center">
								<div class="col-xs-9">
									<h6 class="text-right">Added items?</h6>
								</div>
								<div class="col-xs-3">
									<button type="button" class="btn btn-default btn-sm btn-block">
										Update cart
									</button>
								</div>
							</div>
						</div> -->
					</div>
					<div class="panel-footer">
						<div class="row text-center">
							<div class="col-xs-9">
								<h4 class="text-right">Total <strong>${orders.cartItem.productprice }</strong></h4>
							</div>
							<div class="col-xs-3">
								<input type="submit" class="btn btn-success btn-block" name="_eventId_setPayment" value="Continue">
							</div>
						</div>
					</div>
				</div>
				</form:form>
			</div>
		</div>
<jsp:include page="/WEB-INF/views/templates/footer.jsp"/>