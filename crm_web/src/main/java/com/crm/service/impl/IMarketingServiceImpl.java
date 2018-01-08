package com.crm.service.impl;

import com.crm.dao.SaleChanceDao;
import com.crm.model.SaleChance;
import com.crm.service.IMarketingService;
import com.crm.utils.ResultInfo;
import com.crm.utils.StringUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
        if(StringUtil.isNotEmpty(saleChance.getCreateMan())){
            params.put("createMan", saleChance.getCreateMan());
        }

        //条件查询 客户名称
        if(StringUtil.isNotEmpty(saleChance.getCustomerName())){
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
    @Transactional
    public ResultInfo insertMarketing(SaleChance saleChance) {
        saleChance.setCreateDate(new Date());
        saleChance.setUpdateDate(new Date());
        saleChance.setIsValid(1);
        saleChance.setState(1); //已分配
        long saveSte = saleChanceDao.saveSte(saleChance);
        ResultInfo resultInfo = new ResultInfo();
        if(saveSte!=1){
            resultInfo.setCode(500);
            resultInfo.setMsg("添加失败");
        }
        return resultInfo;
    }

    @Override
    @Transactional
    public ResultInfo updateMarketing(SaleChance saleChance) {
        ResultInfo resultInfo = new ResultInfo();
        long updateSte = saleChanceDao.updateSte(saleChance);
        if(updateSte!=1){
            resultInfo.setCode(500);
            resultInfo.setMsg("更新失败");
        }
        return resultInfo;
    }

    @Override
    @Transactional
    public ResultInfo deleteMarketing(Integer[] ids) {
        ResultInfo resultInfo = new ResultInfo();

        if(ids.length <= 0){
            resultInfo.setMsg("未选中记录");
            resultInfo.setCode(500);
            return  resultInfo;
        }
        SaleChance saleChance = null;
        int number = 0;

        for(int i = 0;i<ids.length;i++){

            saleChance = new SaleChance();
            saleChance.setId(ids[i]);
            saleChance.setIsValid(0);
            saleChance.setUpdateDate(new Date());
            long updateSte = saleChanceDao.updateSte(saleChance);
            number+=updateSte;
        }

        if (number != ids.length) {
            resultInfo.setCode(500);
            resultInfo.setMsg("删除失败");
        }
        return resultInfo;
    }
}
