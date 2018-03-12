package com.dtproject.dao;

import com.dtproject.model.BillingAddress;

public interface BillingDao {

	BillingAddress findAddressByUserName(String getuName);

}
