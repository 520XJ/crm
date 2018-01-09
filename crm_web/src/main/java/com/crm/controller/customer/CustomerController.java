package com.crm.controller.customer;

import com.crm.model.Customer;
import com.crm.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    //查询所有客户
    @RequestMapping("/queryAllCustomers")
    @ResponseBody
    public List<Customer> queryAllCustomers(){
        return customerService.queryAllCustomers();
    }
}
