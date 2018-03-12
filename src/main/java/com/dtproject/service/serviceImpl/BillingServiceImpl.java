package com.dtproject.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtproject.dao.BillingDao;
import com.dtproject.model.BillingAddress;
import com.dtproject.service.BillingService;

@Service
public class BillingServiceImpl implements BillingService {
	
	@Autowired
	private BillingDao billingDao;

	@Override
	public BillingAddress findAddressByUserName(String getuName) {
		BillingAddress bAdd=billingDao.findAddressByUserName(getuName);
		return bAdd;
	}

}
