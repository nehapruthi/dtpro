package com.dtproject.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtproject.dao.ProductDao;
import com.dtproject.model.Category;
import com.dtproject.model.Product;
import com.dtproject.model.Supplier;


@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveProduct(Product product) {
		Session session=sessionFactory.openSession();
		Category category=(Category) session.get(Category.class, product.getCategory().getcId());
		product.setCategory(category);
		
		Supplier supplier=(Supplier) session.get(Supplier.class, product.getSupplier().getsId());
		product.setSupplier(supplier);
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully inserted data");
		
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		Query query=session.createQuery("From Product");
		List<Product> productList=query.list();
		session.close();
		return productList;
	}

	@Override
	public void deleteProduct(int productId) {
		Session session=sessionFactory.openSession();
		Product prod=(Product)session.get(Product.class, productId);
		session.beginTransaction();
		session.delete(prod);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Product findProductById(int productId) {
		Session session=sessionFactory.openSession();
		Product prod=(Product)session.get(Product.class, productId);
		session.close();
		return prod;
	}

	@Override
	public void updateProduct(Product product) 
	{
		Session session=sessionFactory.openSession();
		Category category=(Category) session.get(Category.class, product.getCategory().getcId());
		product.setCategory(category);
		
		Supplier supplier=(Supplier) session.get(Supplier.class, product.getSupplier().getsId());
		product.setSupplier(supplier);
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
		session.close();
	}

}
