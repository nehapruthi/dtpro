package com.dtproject.dao;

import java.util.List;

import com.dtproject.model.Supplier;

public interface SupplierDao {

	List<Supplier> getAllSuppliers();

	void saveSupplier(Supplier supplier);

	void deleteSupplier(int supplierId);

	void updateSupplier(Supplier supplier);

	Supplier findCategoryById(int supplierId);

}
