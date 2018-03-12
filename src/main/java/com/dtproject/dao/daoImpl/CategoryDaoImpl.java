package com.dtproject.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtproject.dao.CategoryDao;
import com.dtproject.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void saveCategory(Category category) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully inserted data");

	}

	@Override
	public List<Category> getAllCategories() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("FROM Category");
		@SuppressWarnings("unchecked")
		List<Category> catList=query.list();
		session.close();
		return catList;
	}

	@Override
	public void deleteCategory(int categoryId) {
		Session session=sessionFactory.openSession();
		Category category=(Category) session.get(Category.class, categoryId);
		session.beginTransaction();
		session.delete(category);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Category findCategoryById(int categoryId) 
	{
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class, categoryId);	
		return category;
	}

	@Override
	public void updateCategory(Category category) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(category);
		session.getTransaction().commit();
		session.close();	
		
	}

}
