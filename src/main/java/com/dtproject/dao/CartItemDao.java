package com.dtproject.dao;

import java.util.List;

import com.dtproject.model.Cart;
import com.dtproject.model.CartItem;

public interface CartItemDao {

	List<CartItem> findByCartId(int cartId);

	void updateCartItem(CartItem cartItem, Cart cart);

}
