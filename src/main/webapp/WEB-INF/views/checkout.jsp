<jsp:include page="/WEB-INF/views/templates/header.jsp"/>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title">
							<div class="row">
								<div class="col-xs-12">
									<h5><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>
								</div>
								<div class="col-xs-6">
									<button type="button" class="btn btn-default">
			                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
			                        </button>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-xs-2"><img class="img-responsive" src="Resources/images/${orders.product.pImg}" alt="${orders.product.pImg}">
							</div>
							<div class="col-xs-4">
								<h4 class="product-name"><strong>${orders.product.pName}</strong></h4><h4><small>${orders.product.pDescription}</small></h4>
							</div>
							<div class="col-xs-6">
								<div class="col-xs-6 text-right">
									<h6><strong>${orders.cartItem.productprice} <span class="text-muted">x</span></strong></h6>
								</div>
								<div class="col-xs-4">
									<input type="text" class="form-control input-sm" value="${orders.cartItem.quantity }">
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
							<div class="col-xs-8">
								<h3><strong>Shipping Address : </strong></h3>
								<h4><strong><small>Address</small></strong> ${orders.sAddress.address }</h4>
								<h4>
									<ul class="list-unstyled">
										<li><strong>City : </strong>${orders.sAddress.city}</li>
										<li><strong>State : </strong>${orders.sAddress.state}</li>
										<li><strong>Pincode : </strong>${orders.sAddress.pincode}</li>
									</ul>
								</h4>
							</div>
						</div>
						<!-- <hr>
						<div class="row">
							<div class="text-center">
								<div class="col-xs-9">
									<h6 class="text-right">Added items?</h6>
								</div>
								<div class="col-xs-3">
									<a type="button" class="btn btn-default btn-sm btn-block">
										Update cart
									</a>
								</div>
							</div>
						</div> -->
					</div>
					<div class="panel-footer">
						<div class="row text-center">
							<div class="col-xs-9">
								<h4 class="text-right">Total <strong>${cartItem.productprice }</strong></h4>
							</div>
							<div class="col-xs-3">
								<a href="${flowExecutionUrl}&amp;_eventId=checkoutSuccess" type="button" class="btn btn-success btn-block">
									Checkout
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/views/templates/footer.jsp"/>