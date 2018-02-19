package com.crm.controller.customer;

import com.crm.framework.context.BaseController;
import com.crm.model.CustomerLoss;
import com.crm.service.ICustomerLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/customer_loss")
public class CustomerLossController extends BaseController{

    @Autowired
    private ICustomerLossService customerLossService;

    @RequestMapping("/index.shtml")
    public String index(){
        return "customer_loss";
    }

    /**
     *
     * @param customerLoss
     * @return
     */
    @RequestMapping("/queryCustomerLossesByParams")
    @ResponseBody
    public Map<String,Object> queryCustomerLossesByParams(CustomerLoss customerLoss){
        return customerLossService.queryCustomerLossesByParams(customerLoss);
    }

}
