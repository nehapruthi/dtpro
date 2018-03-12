package com.dtproject.service;

import com.dtproject.model.BillingAddress;

public interface BillingService {

	BillingAddress findAddressByUserName(String getuName);

}
