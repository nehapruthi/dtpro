package com.dtproject.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtproject.dao.ShippingDao;
import com.dtproject.model.ShippingAddress;

@Repository
public class ShippingDaoImpl implements ShippingDao {
	
	@Autowired
	SessionFactory sf;

	@Override
	public List<ShippingAddress> getShippingAddressByUsername(String getuName) {
		Session session=sf.openSession();
		Query query=session.createQuery("From ShippingAddress where username=:s");
		query.setParameter("s", getuName);
		return query.list();
	}

}
