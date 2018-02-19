package com.crm.service.impl;

import com.crm.dao.CustomerLossDao;
import com.crm.model.CustomerLoss;
import com.crm.service.ICustomerLossService;
import com.crm.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ICustomerLossImpl implements ICustomerLossService {

    @Autowired
    private CustomerLossDao customerLossDao;

    @Override
    public Map<String, Object> queryCustomerLossesByParams(CustomerLoss customerLoss) {

        //分页
        PageHelper.startPage(customerLoss.getPage(), customerLoss.getRows());

        Map<String, Object> param = new HashMap<>();

        //客户名称   条件查询
        if (StringUtil.isNotEmpty(customerLoss.getCusName())) {
            param.put("cusName", customerLoss.getCusName());
        }

        //客户编号  条件查询
        if (StringUtil.isNotEmpty(customerLoss.getCusNo())) {
            param.put("cusNo",customerLoss.getCusNo());
        }

        //客户经理  条件查询
        if (StringUtil.isNotEmpty(customerLoss.getCusManager())) {
            param.put("cusManager", customerLoss.getCusManager());
        }

        //创建时间  条件查询
        if (customerLoss.getCreateDate() != null) {
            param.put("createDate", customerLoss.getCreateDate());
        }

        param.put("isValid", 1);

        List<CustomerLoss> list = customerLossDao.find(param);

        PageInfo<CustomerLoss> pageInfo = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();

        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());

        return map;
    }
}
