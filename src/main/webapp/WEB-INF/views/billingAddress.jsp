    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <jsp:include page="/WEB-INF/views/templates/header.jsp"/>
<div class="container">
	<div class="row">
        <div class="span8">
    		<form action="billing" method="post" class="form-horizontal" id="billingform" accept-charset="utf-8">
    			<div class="control-group">
    				<label for="email" class="control-label">	
    					Billing E-Mail 
    				</label>
    				<div class="controls">
    					<input name="email" type="email" value="" id="email">
    					<span class="help-inline">  Where should we send invoices?</span>
    				</div>
    			</div>
     
    			<div class="control-group">
    				<label for="address" class="control-label">	
    					Street Address
    				</label>
    				<div class="controls"><input name="address" placeholder="W 123 Street" type="text" value="" id="address"><span class="help-inline">  Street Name and/or apartment number</span>
    				</div>
    			</div>
     
    			<div class="control-group">
    				<label for="zip" class="control-label">	
    					Zip Code
    				</label>
    				<div class="controls"><input name="zip" type="text" value="" id="zip">
    				</div>
    			</div>
     
    			<div class="control-group">
    				<label for="city" class="control-label">	
    					City
    				</label>
    				<div class="controls"><input name="city" type="text" value="" id="city">
    				</div>
    			</div>
    			
    			<div class="control-group">
    				<label for="country" class="control-label">	
    					Country
    				</label>
    				<div class="controls">
    					
    				</div>
    			</div>
     
    			<div class="form-actions">
    				<button type="submit" class="btn btn-large btn-primary">Save Billing Address</button>
    			</div>
    		</form>
    	</div> <!-- .span8 -->
	</div>
</div>
<jsp:include page="/WEB-INF/views/templates/footer.jsp"/>