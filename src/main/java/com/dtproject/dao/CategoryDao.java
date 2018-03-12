package com.dtproject.dao;

import java.util.List;

import com.dtproject.model.Category;

public interface CategoryDao {

	void saveCategory(Category category);

	List<Category> getAllCategories();

	void deleteCategory(int categoryId);

	Category findCategoryById(int categoryId);

	void updateCategory(Category category);

}
