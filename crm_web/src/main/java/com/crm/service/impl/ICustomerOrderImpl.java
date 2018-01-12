package com.crm.service.impl;

import com.crm.dao.CustomerOrderDao;
import com.crm.dao.OrderDetailsDao;
import com.crm.model.CustomerOrder;
import com.crm.model.OrderDetails;
import com.crm.service.ICustomerOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ICustomerOrderImpl implements ICustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;


    @Override
    public Map<String, Object> queryOrdersByCid(Integer cid, Integer page, Integer rows) {

        //分页
        PageHelper.startPage(page, rows);

        Map<String ,Object> param = new HashMap<>();
        param.put("cusId", cid);
        param.put("isValid",1);

        List<CustomerOrder> list = customerOrderDao.find(param);

        PageInfo<CustomerOrder> pageInfo = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();

        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());

        return map;
    }

    @Override
    public Map<String, Object> queryCustoemrOrderByOrderId(Integer orderId, Integer page, Integer rows) {

        //分页
        PageHelper.startPage(page, rows);

        Map<String ,Object> param = new HashMap<>();
        param.put("orderId", orderId);
        param.put("isValid", 1);
        List<OrderDetails> list = orderDetailsDao.find(param);

        PageInfo<OrderDetails> pageInfo = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();

        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());

        return map;
    }
}
