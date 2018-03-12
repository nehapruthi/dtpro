package com.dtproject.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtproject.dao.CartDao;
import com.dtproject.model.BillingAddress;
import com.dtproject.model.Cart;
import com.dtproject.model.CartItem;
import com.dtproject.model.Orders;
import com.dtproject.model.ShippingAddress;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	SessionFactory sf;

	@Override
	public Cart findCartByCartId(int cartId) {
		Session session=sf.openSession();
		Cart cart=(Cart) session.get(Cart.class, cartId);
		return cart;
	}

	@Override
	public void saveOrder(Orders orders, int id) {
		Session session=sf.openSession();
			
		Cart cart=(Cart) session.get(Cart.class, id);
		cart.setGrandTotal(cart.getGrandTotal()+orders.getCartItem().getProductprice());
		cart.setTotalItems(cart.getTotalItems()+1);
		
		session.beginTransaction();		
		ShippingAddress sAdd=orders.getsAddress();
		BillingAddress bAdd=orders.getbAddress();
		session.saveOrUpdate(sAdd);
		session.saveOrUpdate(bAdd);
		
		CartItem cartItem=orders.getCartItem();
		cartItem.setBillingAddress(bAdd.getBillingId());
		cartItem.setShippingAddress(sAdd.getShippingId());
		orders.setCartItem(cartItem);
		orders.setbAddress(bAdd);
		orders.setsAddress(sAdd);
		
		session.saveOrUpdate(orders);
		session.update(cart);
		session.getTransaction().commit();
		session.close();
	}

}
