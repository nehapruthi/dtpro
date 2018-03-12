package com.dtproject.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtproject.dao.CategoryDao;
import com.dtproject.model.Category;
import com.dtproject.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void saveCategory(Category category) {
		categoryDao.saveCategory(category);

	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> catList= (List<Category>)categoryDao.getAllCategories();
		return catList;
	}

	@Override
	public void deleteCategory(int categoryId) 
	{
	categoryDao.deleteCategory(categoryId);	
		
	}

	@Override
	public Category findCategoryById(int categoryId) {
		Category category=categoryDao.findCategoryById(categoryId);
		return category;
	}

	@Override
	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
		
	}


}
