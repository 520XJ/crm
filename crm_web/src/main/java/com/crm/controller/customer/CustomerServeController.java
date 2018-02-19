package com.crm.controller.customer;

import com.crm.framework.context.BaseController;
import com.crm.model.CustomerServe;
import com.crm.service.ICustomerServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * 服务管理模块
 */
@RequestMapping("/customer_serve")
@Controller
public class CustomerServeController extends BaseController {

    @Autowired
    private ICustomerServeService customerServeService;

    @RequestMapping("{number}/index.shtml")
    public String index(@PathVariable("number") Integer number) {
        switch (number) {
            case 1:
                return "customer_serve_create";//服务创建
            case 2:
                return "customer_serve_assign";//服务分配
            case 3:
                return "";
            case 4:
                return "";
        }
        return null;
    }

    @RequestMapping("queryCustomerServesByParams")
    @ResponseBody
    public Map<String, Object> queryCustomerServesByParams(CustomerServe customerServe) {

        return customerServeService.queryCustomerServesByParams(customerServe);
    }



}
