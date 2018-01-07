package com.crm.service;

import com.crm.model.SaleChance;

import java.util.Map;

public interface IMarketingService {

    public Map<String, Object> querySaleChancesByParams(SaleChance saleChance);
}
