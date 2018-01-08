package com.crm.service;

import com.crm.model.SaleChance;
import com.crm.utils.ResultInfo;

import java.util.Map;

public interface IMarketingService {

    public Map<String, Object> querySaleChancesByParams(SaleChance saleChance);

    public ResultInfo insertMarketing(SaleChance saleChance);
}
