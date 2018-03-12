package com.dtproject.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtproject.dao.CartItemDao;
import com.dtproject.model.Cart;
import com.dtproject.model.CartItem;

@Repository
public class CartItemDaoImpl implements CartItemDao {
	
	@Autowired
	SessionFactory sf;

	@Override
	public List<CartItem> findByCartId(int cartId) {
		Session session=sf.openSession();
		Query query=session.createQuery("From CartItem where cartId=:c");
		query.setParameter("c", cartId);
		return query.list();
	}

	@Override
	public void updateCartItem(CartItem cartItem, Cart cart) {
		Session session=sf.openSession();
		session.beginTransaction();
		session.update(cartItem);
		session.update(cart);
		session.getTransaction().commit();
		session.close();
	}

}
