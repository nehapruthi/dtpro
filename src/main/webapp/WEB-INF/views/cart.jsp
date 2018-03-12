
<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table">
            <caption>
            	<h2>${cart.totalItems} Items found in your Cart.</h2>
            </caption>
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="item" varStatus="st" items="${itemList}">
                
                
                	<%-- <c:forEach var="product" items="${proList}"> --%>
                    <tr>
                    <form action="" id="myForm${st.count}">
                        <td class="col-sm-5 col-md-5">
                        <div class="media">
                            <div class="media-left">
                            	<img class="media-object" src="Resources/images/${item.value.pImg}" alt="${item.value.pImg}" style="width: 80px;">
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${item.value.pName }</a></h4>
                                <h5 class="media-heading"> by <a href="#">Supplier : ${item.value.supplier.sName}</a></h5>
                                <span>Status: </span><span class="text-success"><strong></strong></span>
                            </div>
                        </div></td>
                        <td class="col-sm-2 col-md-2">
                        <div class="row">
						  <div class="col-md-12">
						    <div class="input-group">
						      <span class="input-group-btn">
						        <button type="button" class="btn btn-default" id="btn-minus" onclick="button1(${st.count})" >
						            <span class="glyphicon glyphicon-minus"></span>
						        </button>
						      </span>
						      <input type="text" class="form-control" id="quantity${st.count}" value="${item.key.quantity}"/>
						      <span class="input-group-btn">
						        <button type="button" class="btn btn-default" id="btn-plus" onclick="button2(${st.count})" >
							        <span class="glyphicon glyphicon-plus"></span>
							    </button>
						      </span>
						    </div><!-- /input-group -->
						  </div><!-- /.col-lg-6 -->
						</div>
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${item.value.pPrice }</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${item.key.productprice}</strong></td>
                        <td class="col-sm-3 col-md-3">
                        	<button type="button" class="btn btn-info" onclick="updateFunction(${item.key.cartItem_id},${st.count})">
	                            <span class="glyphicon glyphicon-pencil"></span> Update
	                        </button>
	                        <button type="button" class="btn btn-danger" onclick="deleteFunction(${item.key.cartItem_id},${st.count})">
	                            <span class="glyphicon glyphicon-remove"></span> Remove
	                        </button>
                        </td>
                      </form>
                    </tr>
                    <%-- </c:forEach> --%>
                </c:forEach>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Subtotal</h5></td>
                        <td class="text-right"><h5><strong>${total}</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Estimated shipping</h5></td>
                        <td class="text-right"><h5><strong>${(total*1)/100}</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3><strong>${(total*101)/100}</strong></h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
	                        <!-- <button type="button" class="btn btn-default">
	                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
	                        </button> -->
                        </td>
                        <td>
	                        <!-- <button type="button" class="btn btn-success">
	                            Checkout <span class="glyphicon glyphicon-play"></span>
	                        </button> -->
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
function updateFunction(cid,myId) {
	var myForm=document.getElementById('myForm'+myId);
	console.log(myForm)
	var quantity=document.getElementById("quantity"+myId).value;
	
	console.log(quantity);
	
	myForm.action="updateCart/"+cid+"/"+quantity;
     myForm.submit(); 
}
function deleteFunction(cid,myId){
	var myForm=document.getElementById('myForm'+myId);
	console.log(myForm)

	myForm.action="deleteCart/"+cid;
     myForm.submit(); 
}
function button1(c)
	{
	    var e=document.getElementById('quantity'+c);
	    var val=parseInt(e.value);
	    if(val>1){
	        e.value=val-1;
	    }
	}
	function button2(c)
	{
	    var e=document.getElementById('quantity'+c);
	    var val=parseInt(e.value);
	    if(val>=1){
	        e.value=val+1;
	    }
	}
</script>
<%@ include file="/WEB-INF/views/templates/footer.jsp" %>