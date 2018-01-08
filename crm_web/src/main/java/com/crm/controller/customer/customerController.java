package com.crm.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class customerController {

    //查询所有客户
    @RequestMapping("/queryAllCustomers")
    @ResponseBody
    public List<Object> queryAllCustomers(){
        return null;
    }
}
