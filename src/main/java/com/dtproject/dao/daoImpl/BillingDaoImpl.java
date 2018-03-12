package com.dtproject.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtproject.dao.BillingDao;
import com.dtproject.model.BillingAddress;


@Repository
public class BillingDaoImpl implements BillingDao {
	
	@Autowired
	SessionFactory sf;
	@Override
	public BillingAddress findAddressByUserName(String getuName) {
		Session session=sf.openSession();
		Query query=session.createQuery("From BillingAddress where username=:u");
		query.setParameter("u", getuName);
		BillingAddress bAdd=(BillingAddress) query.list().get(0);
		return bAdd;
	}

}
