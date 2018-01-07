package com.crm.controller.marketing;

import com.crm.framework.context.BaseController;
import com.crm.model.SaleChance;
import com.crm.service.IMarketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 *  营销机会
 */
@Controller
@RequestMapping("/marketing")
public class MarketingController extends BaseController{

    @Autowired
    private IMarketingService marketingService;

    /**
     *            营销机会管理  客户开发计划    页面的跳转
     * @param state
     * @return
     */
    @RequestMapping("/{state}/index.shtml")
    public String index(@PathVariable("state") Integer state){
        //@PathVariable("state"
        //判断  是1 还是 2  分别跳转到不同的页面
        switch (state){
            case 1:
                return "sale_chance";
            case 2:
                return "cus_dev_plan";
            default:
                return "500";
        }
    }

    /**
     *  进入营销机会管理页面所需数据查询
     *  条件查询共用 controller
     * @return
     */
    @RequestMapping("/querySaleChancesByParams")
    @ResponseBody
    public Map<String ,Object> querySaleChancesByParams(SaleChance saleChance) {

        return marketingService.querySaleChancesByParams(saleChance);
    }


}
