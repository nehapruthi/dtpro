package com.dtproject.dao;

import com.dtproject.model.Cart;
import com.dtproject.model.Orders;

public interface CartDao {

	Cart findCartByCartId(int cartId);

	void saveOrder(Orders orders, int id);


}
