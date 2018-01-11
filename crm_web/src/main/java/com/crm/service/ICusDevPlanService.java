package com.crm.service;

import com.crm.model.CusDevPlan;
import com.crm.model.SaleChance;
import com.crm.utils.ResultInfo;

import java.util.Map;

public interface ICusDevPlanService {

    public SaleChance querySaleChanceById(Integer sid);

    public Map<String, Object> queryCusDevPlansByParams(CusDevPlan cusDevPlan);

    public ResultInfo insertCusDevPlan(CusDevPlan cusDevPlan);

    public ResultInfo deleteCusDevPlanById(Integer id);

}
