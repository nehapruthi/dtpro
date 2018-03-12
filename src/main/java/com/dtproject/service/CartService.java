package com.dtproject.service;

import com.dtproject.model.Cart;
import com.dtproject.model.Orders;

public interface CartService {

	Cart findCartByCartId(int cartId);

	void saveOrder(Orders orders, int id);

}
