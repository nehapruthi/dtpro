package com.dtproject.dao;

import java.util.List;

import com.dtproject.model.Product;

public interface ProductDao {
	
	void saveProduct(Product product);

	List<Product> getAllProducts();

	void deleteProduct(int productId);

	Product findProductById(int productId);

	void updateProduct(Product product);

}
