package com.crm.service;

import com.crm.model.CustomerLoss;

import java.util.Map;

public interface ICustomerLossService {

    public Map<String,Object> queryCustomerLossesByParams(CustomerLoss customerLoss);

}
