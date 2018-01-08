package com.crm.service.impl;

import com.crm.dao.CustomerDao;
import com.crm.model.Customer;
import com.crm.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ICustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> queryAllCustomers() {

        Map<String,Object> map = new HashMap<>();
        map.put("isValid", 1);
        List<Customer> customers = customerDao.find(map);

        return customers;
    }
}
