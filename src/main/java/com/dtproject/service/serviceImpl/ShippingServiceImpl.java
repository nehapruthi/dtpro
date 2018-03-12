package com.dtproject.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtproject.dao.ShippingDao;
import com.dtproject.model.ShippingAddress;
import com.dtproject.service.ShippingService;

@Service
public class ShippingServiceImpl implements ShippingService {
	
	@Autowired
	private ShippingDao shippingDao;

	@Override
	public List<ShippingAddress> getShippingAddressByUsername(String getuName) {
		List<ShippingAddress> shippingAddress=shippingDao.getShippingAddressByUsername(getuName);
		return shippingAddress;
	}

}
