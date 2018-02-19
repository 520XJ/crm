package com.crm.service.impl;

import com.crm.dao.CustomerServeDao;
import com.crm.model.CustomerServe;
import com.crm.service.ICustomerServeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ICustomerServeImpl implements ICustomerServeService{

    @Autowired
    private CustomerServeDao customerServeDao;


    @Override
    public Map<String, Object> queryCustomerServesByParams(CustomerServe customerServe) {

        PageHelper.startPage(customerServe.getPage(), customerServe.getRows());

        Map<String,Object> parms = new HashMap<>();
        parms.put("isValid", 1);
        parms.put("state", customerServe.getState());

        List<CustomerServe> list = customerServeDao.find(parms);

        PageInfo<CustomerServe> pageInfo = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();

        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }
}
