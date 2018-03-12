package com.dtproject.dao;

import java.util.List;

import com.dtproject.model.ShippingAddress;

public interface ShippingDao {

	List<ShippingAddress> getShippingAddressByUsername(String getuName);

	

}
