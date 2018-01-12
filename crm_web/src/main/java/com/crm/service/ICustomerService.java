package com.crm.service;

import com.crm.model.Customer;
import com.crm.model.CustomerOrder;
import com.crm.model.Datadic;
import com.crm.utils.ResultInfo;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    public List<Customer> queryAllCustomers();

    public Map<String,Object> queryCustomersByParams(Customer customer);

    public List<Datadic> queryDataDicValueByDataDicName(String dataDicName);

    public ResultInfo insertCustomer(Customer customer);

    public ResultInfo updateCustomer(Customer customer);

    public ResultInfo deleteCustomerById(Integer[] ids);

    public Customer queryCustomerById(Integer id);

}
