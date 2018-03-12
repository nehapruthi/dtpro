package com.dtproject.service;

import java.util.List;

import com.dtproject.model.Product;

public interface ProductService {
	
	void saveProduct(Product product);

	List<Product> getAllProducts();

	String deleteProduct(int productId);

	Product findProductById(int productId);

	void updateProduct(Product product);


}
