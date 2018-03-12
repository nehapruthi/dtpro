package com.dtproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dtproject.model.Cart;
import com.dtproject.model.CartItem;
import com.dtproject.model.Product;
import com.dtproject.model.User;
import com.dtproject.service.CartItemService;
import com.dtproject.service.CartService;
import com.dtproject.service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;

	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/addIntoCart")
	public String addIntoCart(@RequestParam("pid") int productId, @RequestParam("quantity") int quantity)
	{
		return "redirect:/myFlow?pid="+productId+"&quantity="+quantity;
	}
	
	@RequestMapping("/cart")
	public ModelAndView showCart(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("activeUser");
		System.out.println(user.getuName());
		System.out.println(user.getCartId());
		Cart cart=cartService.findCartByCartId(user.getCartId());
		
		ModelAndView mv=new ModelAndView();
		List<CartItem> cartItemList=cartItemService.findByCartId(user.getCartId());
		Map<CartItem, Product> items=new HashMap<CartItem,Product>();
		int total=0;
		for(CartItem c:cartItemList) {
			Product product=productService.findProductById(c.getProductId());
			total+=c.getProductprice();
			items.put(c, product);
		}
		
		mv.addObject("cart",cart);
		mv.addObject("itemList",items);
		mv.addObject("total",total);
		mv.setViewName("cart");
		return mv;
	}
	
	@RequestMapping("/updateCart/{cid}/{quantity}")
	public String updateCart(@PathVariable("cid") int cId, @PathVariable("quantity") int quantity, HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("activeUser");
		Cart cart=cartService.findCartByCartId(user.getCartId());
		CartItem cartItem=null;
		
		List<CartItem> cartItemList=cartItemService.findByCartId(user.getCartId());
		for(CartItem cart1:cartItemList)
		{
			if(cId==cart1.getCartItem_id())
			{
				Product product=productService.findProductById(cart1.getProductId());
				cart1.setQuantity(quantity);
				cart1.setProductprice(quantity*product.getpPrice());
				cartItem=cart1;
				if(quantity>cartItem.getQuantity())
				{
					quantity=quantity-cartItem.getQuantity();
					cart.setGrandTotal(cart1.getProductprice()+(quantity*product.getpPrice()));
				}
				else
				{
					quantity=cartItem.getQuantity()-quantity;
					cart.setGrandTotal(cart1.getProductprice()-(quantity*product.getpPrice()));
				}
				break;
			}
		}
		
		cartItemService.updateCartItem(cartItem, cart);
		return "redirect:/cart";
	}
}
