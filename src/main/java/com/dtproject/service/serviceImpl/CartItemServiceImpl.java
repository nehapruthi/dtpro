package com.dtproject.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtproject.dao.CartItemDao;
import com.dtproject.model.Cart;
import com.dtproject.model.CartItem;
import com.dtproject.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public List<CartItem> findByCartId(int cartId) {
		List<CartItem> cartItem=cartItemDao.findByCartId(cartId);
		return cartItem;
	}


	@Override
	public void updateCartItem(CartItem cartItem, Cart cart) {
		cartItemDao.updateCartItem(cartItem, cart);
		
	}

}
