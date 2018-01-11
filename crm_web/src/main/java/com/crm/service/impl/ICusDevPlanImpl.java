package com.crm.service.impl;

import com.crm.dao.CusDevPlanDao;
import com.crm.dao.SaleChanceDao;
import com.crm.model.CusDevPlan;
import com.crm.model.SaleChance;
import com.crm.service.ICusDevPlanService;
import com.crm.utils.ResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ICusDevPlanImpl implements ICusDevPlanService {

    @Autowired
    private SaleChanceDao saleChanceDao;

    @Autowired
    private CusDevPlanDao cusDevPlanDao;

    @Override
    public SaleChance querySaleChanceById(Integer sid) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", sid);
        map.put("isValid", 1);
        SaleChance saleChance = saleChanceDao.findOne(map);
        return saleChance;
    }

    @Override
    public Map<String, Object> queryCusDevPlansByParams(CusDevPlan cusDevPlan) {

        //分页
        PageHelper.startPage(cusDevPlan.getPage(), cusDevPlan.getRows());
        Map<String, Object> param = new HashMap<>();
        param.put("saleChanceId", cusDevPlan.getSaleChanceId());
        param.put("isValid", 1);
        List<CusDevPlan> cusDevPlans = cusDevPlanDao.find(param);

        PageInfo<CusDevPlan> pageInfo = new PageInfo<>(cusDevPlans);
        Map<String,Object> map = new HashMap<>();

        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());

        return map;
    }

    @Override
    public ResultInfo insertCusDevPlan(CusDevPlan cusDevPlan) {
        ResultInfo resultInfo = new ResultInfo();
        cusDevPlan.setIsValid(1);
        cusDevPlan.setCreateDate(new Date());
        cusDevPlan.setUpdateDate(new Date());
        long saveSte = cusDevPlanDao.saveSte(cusDevPlan);
        if(saveSte!=1){
            resultInfo.setCode(500);
            resultInfo.setMsg("添加失败");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo deleteCusDevPlanById(Integer id) {
        ResultInfo resultInfo = new ResultInfo();
        CusDevPlan cusDevPlan = new CusDevPlan();
        cusDevPlan.setId(id);
        cusDevPlan.setIsValid(0);
        cusDevPlan.setUpdateDate(new Date());
        long updateSte = cusDevPlanDao.updateSte(cusDevPlan);
        if (updateSte != 1) {
            resultInfo.setCode(500);
            resultInfo.setMsg("删除失败");
        }
        return resultInfo;
    }

}
