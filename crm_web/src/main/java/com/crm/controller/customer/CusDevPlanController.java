package com.crm.controller.customer;

import com.crm.framework.context.BaseController;
import com.crm.model.CusDevPlan;
import com.crm.model.SaleChance;
import com.crm.service.ICusDevPlanService;
import com.crm.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RequestMapping("/cus_dev_plan")
@Controller
public class CusDevPlanController extends BaseController {

    @Autowired
    private ICusDevPlanService cusDevPlanService;

    //营销管理-->客户开发计划-->查看开发详情
    @GetMapping("/index.shtml")
    public ModelAndView index(@RequestParam("sid") Integer sid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cus_dev_plan_detail");  //视图
        SaleChance saleChance = cusDevPlanService.querySaleChanceById(sid);
        modelAndView.addObject("saleChance", saleChance);
        return modelAndView;
    }

    //营销管理-->客户开发计划-->查看开发详情-->开发计划项
    @PostMapping("/queryCusDevPlansByParams")
    @ResponseBody
    public Map<String, Object> queryCusDevPlansByParams(CusDevPlan cusDevPlan){
        return cusDevPlanService.queryCusDevPlansByParams(cusDevPlan);
    }

    //营销管理-->客户开发计划-->查看开发详情-->开发计划项-->添加计划
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo insertCusDevPlan(CusDevPlan cusDevPlan){
        return cusDevPlanService.insertCusDevPlan(cusDevPlan);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultInfo deleteCusDevPlanById(@RequestParam("id") Integer id) {

        return cusDevPlanService.deleteCusDevPlanById(id);
    }

}
