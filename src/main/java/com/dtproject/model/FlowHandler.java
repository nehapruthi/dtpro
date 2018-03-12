package com.dtproject.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.dtproject.service.BillingService;
import com.dtproject.service.CartItemService;
import com.dtproject.service.CartService;
import com.dtproject.service.ProductService;
import com.dtproject.service.ShippingService;
import com.dtproject.service.UserService;

@Component
public class FlowHandler {
	
	@Autowired
	private User user;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShippingService shippingService;
	
	@Autowired
	private BillingService billingService;
	
	@Autowired
	private CartService cartService;
	
	private List<ShippingAddress> addressList;
	
	public void initOrders()
	{
		System.out.println("Init orders");
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		user=userService.findUserByName(username);
	}
	
	public Orders addToCart(int pId, int pQuantity, Orders orders)
	{
		orders.setsAddress(new ShippingAddress());
		Product product=productService.findProductById(pId);
		orders.setProduct(product);
		
		List<CartItem> cartItems=cartItemService.findByCartId(user.getCartId());
		CartItem cart=new CartItem();
		int i=0;
		for(CartItem cartItem: cartItems)
		{
			if(cartItem.getProductId()==pId)
			{
				cart.setCartId(cartItem.getCartId());
				cart.setCartItem_id(cartItem.getCartItem_id());
				cart.setProductId(cartItem.getProductId());
				cart.setProductprice(cartItem.getProductprice()+(product.getpPrice()*pQuantity));
				cart.setQuantity(cartItem.getQuantity()+pQuantity);
				i=1;
			}
		}
		if(i==0)
		{
			cart.setCartId(user.getCartId());
			cart.setProductId(pId);
			cart.setQuantity(pQuantity);
			cart.setProductprice(product.getpPrice());
		}
		orders.setCartItem(cart);
		return orders;
	}
	
	public String checkShippingAddress()
	{
		List <ShippingAddress> shippingAddress=shippingService.getShippingAddressByUsername(user.getuName());
		if(shippingAddress.isEmpty())
		{
			System.out.println("Shipping address is empty");
			return "empty";
		}
		else
		{
			System.out.println("Available shipping address");
			addressList=shippingAddress;
			return "available";
		}
		
	}
		
	public Orders setNewAddress(Orders orders, RequestContext context) {
		String s=context.getRequestParameters().get("billingAddress");
		ShippingAddress shipAdd=orders.getsAddress();
		shipAdd.setUsername(user.getuName());
		orders.setsAddress(shipAdd);
		if(!s.equals(null))
		{
			if(s.equals("on"))
			{
			orders=setBillingAddress(orders);
			}
		}
		
		addressList=new ArrayList<ShippingAddress>();
			
		addressList.add(shipAdd);
		orders=attachAddress(orders);
		return orders;
	}
	
	public Orders setBillingAddress(Orders orders)
	{
		System.out.println("setting billing address");
		ShippingAddress shipAdd=orders.getsAddress();
		
		BillingAddress billAdd=new BillingAddress();
		billAdd.setAddress(shipAdd.getAddress());
		billAdd.setCity(shipAdd.getCity());
		billAdd.setPincode(shipAdd.getPincode());
		billAdd.setState(shipAdd.getState());
		billAdd.setUsername(user.getuName());
		orders.setbAddress(billAdd);
		return orders;
	}
	
	public Orders attachAddress(Orders orders)
	{
		orders.setShippingAddressList(addressList);
		return orders;
	}
	
	public Orders setSelectedAddress(Orders orders, RequestContext context)
	{
		
		String s=context.getRequestParameters().get("billingAddress");
		ShippingAddress shipAdd=orders.getsAddress();
		
		int sId=orders.getsAddress().getShippingId();
		for(ShippingAddress sAdd :orders.getShippingAddressList())
		{
			if(sAdd.getShippingId()==sId)
			{
				if(s!=null)
				{
					if(s.equals("on"))
					{
					BillingAddress bAdd=billingService.findAddressByUserName(user.getuName());
					orders.setbAddress(bAdd);
					}
				}
				orders.setsAddress(sAdd);
			}
		}
		return orders;
		
	}
	
	public Orders myPayment(Orders orders)
	{
		orders.setPayment(new Payment());
		return orders;
		
	}
	
	public String saveOrder(Orders orders)
	{
		try {
		cartService.saveOrder(orders, user.getCartId());
//		SimpleMailMessage m=new SimpleMailMessage();
//		m.setFrom("neha.pruthi4@gmail.com");
//		m.setTo(user.getEmail());
//		m.setBcc("yadavdp01@gmail.com");
//		m.setSubject("Order Confirmation");
//		m.setText("<h1>Order confirmed</h1>");
		String host="smtp.gmail.com";
		String from="neha.pruthi4@gmail.com";
		String pass="Buttercup2014";
		
		/*Properties props=new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.username", from);
		props.put("mail.smtp.password", pass);
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props);*/
		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				  
                MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
                helper.setFrom(from);
                helper.setTo(user.getEmail());
                helper.setSubject("Order Confirmation");
                helper.setText("<h1 style=\"color:dodgerblue;font-family:sans-serif;font-size:40px;\">Confirm Order</h1>"+
                		"  <body class=\"main\">\r\n"+
                		"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
                		"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
                		"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>"+ 
                		"<!------ Include the above in your HEAD tag ---------->\r\n" + 
                		"\r\n" + 
                		"\r\n" + 
                		"\r\n" + 
                		"    \r\n" + 
                		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
                		"    \r\n" + 
                		"    <link rel=\"icon\" href=\"../../favicon.ico\">\r\n" + 
                		"\r\n" + 
                		"\r\n" + 
                		"   <style>\r\n" + 
                		"       /* Everything but the jumbotron gets side spacing for mobile first views */\r\n" + 
                		".header,\r\n" + 
                		".marketing,\r\n" + 
                		".footer {\r\n" + 
                		"  padding-right: 15px;\r\n" + 
                		"  padding-left: 15px;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		"/* Make the masthead heading the same height as the navigation */\r\n" + 
                		".header h3 {\r\n" + 
                		"  margin-top: 0;\r\n" + 
                		"  margin-bottom: 0;\r\n" + 
                		"  line-height: 40px;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		".table {\r\n" + 
                		"    margin-bottom: 0px;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		".invoice-title h2, .invoice-title h3 {\r\n" + 
                		"    display: inline-block;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		".table > tbody > tr > .no-line {\r\n" + 
                		"    border-top: none;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		".table > thead > tr > .no-line {\r\n" + 
                		"    border-bottom: none;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		".table > tbody > tr > .thick-line {\r\n" + 
                		"    border-top: 2px solid;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		"/* Customize container */\r\n" + 
                		"@media (min-width: 768px) {\r\n" + 
                		"  .container {\r\n" + 
                		"    max-width: 730px;\r\n" + 
                		"    background:#ffffff;\r\n" + 
                		"  }\r\n" + 
                		"}\r\n" + 
                		".container-narrow > hr {\r\n" + 
                		"  margin: 30px 0;\r\n" + 
                		"      background:#ffffff;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		".main {\r\n" + 
                		"  background:#f1f1f1;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		"/* Supporting marketing content */\r\n" + 
                		".marketing {\r\n" + 
                		"  margin: 20px 0 0 0;\r\n" + 
                		"}\r\n" + 
                		".marketing p + h4 {\r\n" + 
                		"  margin-top: 28px;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		"/* Responsive: Portrait tablets and up */\r\n" + 
                		"@media screen and (min-width: 768px) {\r\n" + 
                		"  /* Remove the padding we set earlier */\r\n" + 
                		"  .header,\r\n" + 
                		"  .marketing,\r\n" + 
                		"  .footer {\r\n" + 
                		"    padding-right: 0;\r\n" + 
                		"    padding-left: 0;\r\n" + 
                		"  }\r\n" + 
                		"  /* Space out the masthead */\r\n" + 
                		"  .header {\r\n" + 
                		"    margin-bottom: 30px;\r\n" + 
                		"  }\r\n" + 
                		"  /* Remove the bottom border on the jumbotron for visual effect */\r\n" + 
                		"  .jumbotron {\r\n" + 
                		"    border-bottom: 0;\r\n" + 
                		"  }\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		"body {\r\n" + 
                		"    padding-top: 0px;\r\n" + 
                		"    padding-bottom: 0px;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		".panel-title {display: inline;font-weight: bold;}\r\n" + 
                		".checkbox.pull-right { margin: 0; }\r\n" + 
                		".pl-ziro { padding-left: 0px; }\r\n" + 
                		"\r\n" + 
                		".panel {\r\n" + 
                		"    border: 0px solid transparent;\r\n" + 
                		"    background: #f1f1f1;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		".panel-default>.panel-heading .badge {\r\n" + 
                		"    color: #ffffff;\r\n" + 
                		"    background-color: transparent;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		".container {\r\n" + 
                		"    background: #ffffff;\r\n" + 
                		"    border-radius:10px;\r\n" + 
                		"    margin-top:20px;\r\n" + 
                		"    margin-bottom:20px;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		".panel-heading {\r\n" + 
                		"    border-bottom: 0px solid #555555 !important;\r\n" + 
                		"}\r\n" + 
                		"\r\n" + 
                		".panel-default>.panel-heading {\r\n" + 
                		"    color: #ffffff;\r\n" + 
                		"    background-color: #428bca;\r\n" + 
                		"    padding-bottom: 1px !important;\r\n" + 
                		"}\r\n" + 
                		"   </style>" + 
                		"\r\n" + 
                		"    <div class=\"container\">\r\n" + 
                		"\r\n" + 
                		"      <div class=\"row marketing\">\r\n" + 
                		"      \r\n" + 
                		"        <div class=\"col-lg-12\">\r\n" + 
                		"        \r\n" + 
                		"          <h4><b>Product Name</b></h4>\r\n" + 
                		"<hr />\r\n" + 
                		"\r\n" + 
                		"<div>\r\n" + 
                		"<center>  \r\n" + 
                		"<h4>Success - your order is confirmed!</h4>\r\n" + 
                		"<h5>Order number: #243735374</h5>\r\n" + 
                		"<hr />  \r\n" + 
                		"</div>\r\n" + 
                		"</center>\r\n" + 
                		"        </div>\r\n" + 
                		"\r\n" + 
                		"    <div class=\"row\">\r\n" + 
                		"        <div class=\"col-xs-12\">\r\n" + 
                		"    		<div class=\"row\">\r\n" + 
                		"    			<div class=\"col-xs-3\">\r\n" + 
                		"        			<address>\r\n" + 
                		"    				<strong>Shipping Address:</strong><br>\r\n" +
                		user.getuName()+ "<br>\r\n" + 
                		user.getEmail()+"<br>\r\n" + 
                		user.getPhone()+"<br>\r\n" + 
                		"<strong>Address : </strong>"+orders.getsAddress().getAddress()+"<br>\r\n" +
                		"<strong>City : </strong>"+orders.getsAddress().getCity()+"<br>\r\n" +
                		"<strong>State : </strong>"+orders.getsAddress().getState()+"<br>\r\n" +
                		"<strong>pincode : </strong>"+orders.getsAddress().getPincode()+"<br>\r\n" +
                		"    					ZIP, City, Country\r\n" + 
                		"    				</address>\r\n" + 
                		"\r\n" + 
                		"    			</div>\r\n" + 
                		"    			<div class=\"col-xs-9 text-right\">\r\n" + 
                		"                <img class='img-responsive' height='200' widht='200' src='cid:mypic'/>\r\n" + 
                		"    			</div>\r\n" + 
                		"    		</div>\r\n" + 
                		"    	</div>\r\n" + 
                		"    </div>\r\n" + 
                		"    \r\n" + 
                		"    <div class=\"row\">\r\n" + 
                		"    	<div class=\"col-md-12\">\r\n" + 
                		"    		<div class=\"panel panel-default\">\r\n" + 
                		"    			\r\n" + 
                		"    			<div class=\"panel-body\">\r\n" + 
                		"    				<div class=\"table-responsive\">\r\n" + 
                		"    					<table class=\"table table-condensed\">\r\n" + 
                		"    						<thead>\r\n" + 
                		"                                <tr>\r\n" + 
                		"        							<td><strong>Product Name</strong></td>\r\n" + 
                		"        							<td class=\"text-right\"><strong>Product Description</strong></td>\r\n" + 
                		"            						<td class=\"text-right\"><strong>Quantity</strong></td>\r\n" + 
                		"            						<td class=\"text-right\"><strong>Price</strong></td>\r\n" + 
                		"                                    \r\n" + 
                		"                                </tr>\r\n" + 
                		"    						</thead>\r\n" + 
                		"    						<tbody>\r\n" + 
                		"    							<!-- foreach ($order->lineItems as $line) or some such thing here -->\r\n" + 
                		"    							<tr>\r\n" +    								 
                		"            						<td class=\"text-right\">"+orders.getProduct().getpName()+"</td>\r\n" + 
                		"            						<td class=\"text-right\">"+orders.getProduct().getpDescription()+"</td>\r\n" + 
                		"                                    <td class=\"text-right\">"+orders.getProduct().getpQuantity()+"</td>\r\n" + 
                											"<td class=\"text-right\">"+orders.getProduct().getpPrice()+"</td>\r\n"+
                		"    							</tr>\r\n" + 
                		"    							<tr>\r\n" + 
                		"    								<td class=\"no-line\"></td>\r\n" + 
                		"    								<td class=\"no-line\"></td>\r\n" + 
                		"    								<td class=\"no-line text-right\"><strong>Shipping Charges "+(orders.getProduct().getpPrice()*1)/100+"</strong></td>\r\n" + 
                		"    								<td class=\"no-line text-right\"></td>\r\n" + 
                		"    							</tr>\r\n" + 
                		"    							<tr>\r\n" + 
                		"    								<td class=\"no-line\"></td>\r\n" + 
                		"    								<td class=\"no-line\"></td>\r\n" + 
                		"    								<td class=\"no-line text-right\"><strong>Total "+(orders.getProduct().getpPrice()*101)/100+"</strong></td>\r\n" + 
                		"    								<td class=\"no-line text-right\"></td>\r\n" + 
                		"    							</tr>\r\n" + 
                		"    						</tbody>\r\n" + 
                		"    					</table>\r\n" + 
                		"    				</div>\r\n" + 
                		"    		</div>\r\n" + 
                		"    	</div>\r\n" + 
                		"    </div>\r\n" + 
                		"</div>\r\n" + 
                		"\r\n" + 
                		"      </div>\r\n" + 
                		"\r\n" + 
                		"    </div> <!-- /container -->\r\n" + 
                		"\r\n" + 
                		"\r\n" + 
                		"    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\r\n" + 
                		"    <script src=\"../../assets/js/ie10-viewport-bug-workaround.js\"></script>\r\n" + 
                		"  </body>\r\n" + 
                		"</html>",true);
                
                FileSystemResource file = new FileSystemResource(new File("D:\\dtpro\\src\\main\\webapp\\WEB-INF\\Resources\\images"+File.separator+orders.getProduct().getpImg()));
                helper.addInline("mypic", file);
			}
		};
		mailSender.send(messagePreparator);
		
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return "success";
	}
	
	public String showCart()
	{
		
		return "";
	}
	
}
