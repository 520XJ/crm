package com.crm.service.impl;

import com.crm.dao.SaleChanceDao;
import com.crm.model.SaleChance;
import com.crm.service.IMarketingService;
import com.crm.utils.ResultInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IMarketingServiceImpl implements IMarketingService{

    @Autowired
    private SaleChanceDao saleChanceDao;

    @Override
    public Map<String, Object> querySaleChancesByParams(SaleChance saleChance) {

        //分页参数 页数，每页数据条数
        PageHelper.startPage(saleChance.getPage(), saleChance.getRows());

        Map<String ,Object> params = new HashMap<>();

        //条件查询  创建人
        if(saleChance.getCreateMan()!=null){
            params.put("createMan", saleChance.getCreateMan());
        }

        //条件查询 客户名称
        if(saleChance.getCustomerName()!=null){
            params.put("customerName", saleChance.getCustomerName());
        }

        //条件查询 创建时间
        if (saleChance.getCreateDate() != null) {
            params.put("createDate", saleChance.getCreateDate());
        }

        //条件查询 分配状态
        if (saleChance.getState() != null) {
            params.put("state", saleChance.getState());
        }

        params.put("isValid", 1);
        List<SaleChance> list = saleChanceDao.find(params);

        PageInfo<SaleChance> pageInfo = new PageInfo<>(list);

        //返回数据集合
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return  map;
    }

    @Override
    public ResultInfo insertMarketing(SaleChance saleChance) {
        long saveSte = saleChanceDao.saveSte(saleChance);
        ResultInfo resultInfo = new ResultInfo();
        if(saveSte!=1){
            resultInfo.setCode(500);
            resultInfo.setMsg("添加失败");
        }
        return resultInfo;
    }
}
