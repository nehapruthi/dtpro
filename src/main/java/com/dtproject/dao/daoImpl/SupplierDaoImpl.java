package com.dtproject.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtproject.dao.SupplierDao;
import com.dtproject.model.Product;
import com.dtproject.model.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveSupplier(Supplier supplier) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(supplier);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully inserted data");
		
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("FROM Supplier");
		List<Supplier> supList=query.list();
		session.close();
		return supList;
	}

	@Override
	public void deleteSupplier(int supplierId) 
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier) session.get(Supplier.class, supplierId);
		session.beginTransaction();
		session.delete(supplier);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Supplier findCategoryById(int supplierId) 
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class, supplierId);
		return supplier;
	}
	
	@Override
	public void updateSupplier(Supplier supplier) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(supplier);
		session.getTransaction().commit();
		session.close();
		
	}

	
}
