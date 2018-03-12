package com.dtproject.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtproject.dao.SupplierDao;
import com.dtproject.model.Supplier;
import com.dtproject.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierDao supplierDao;

	@Override
	public void saveSupplier(Supplier supplier) {
		supplierDao.saveSupplier(supplier);

	}

	@Override
	public List<Supplier> getAllSuppliers() {
		List<Supplier> supList=(List<Supplier>)supplierDao.getAllSuppliers();
		return supList;
	}

	@Override
	public void deleteSupplier(int supplierId) {
		supplierDao.deleteSupplier(supplierId);
		
	}

	@Override
	public Supplier findCategoryById(int supplierId) 
	{
		Supplier supplier=supplierDao.findCategoryById(supplierId);
		return supplier;
	}
	
	@Override
	public void updateSupplier(Supplier supplier) {
		supplierDao.updateSupplier(supplier);
		
	}

}
