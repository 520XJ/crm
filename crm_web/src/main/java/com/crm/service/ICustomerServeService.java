package com.crm.service;

import com.crm.model.CustomerServe;

import java.util.Map;

public interface ICustomerServeService {
    public Map<String, Object> queryCustomerServesByParams(CustomerServe customerServe);
}
