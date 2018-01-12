package com.crm.service;

import java.util.Map;

public interface ICustomerOrderService {

    public Map<String, Object> queryOrdersByCid(Integer cid,Integer page,Integer rows);

    public Map<String, Object> queryCustoemrOrderByOrderId(Integer orderId,Integer page,Integer rows);
}
