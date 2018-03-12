package com.dtproject.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtproject.dao.CartDao;
import com.dtproject.model.Cart;
import com.dtproject.model.Orders;
import com.dtproject.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;

	@Override
	public Cart findCartByCartId(int cartId) {
		Cart cart=(Cart) cartDao.findCartByCartId(cartId);
		return cart;
	}

	@Override
	public void saveOrder(Orders orders,int id) {
		cartDao.saveOrder(orders, id);
	}

}
