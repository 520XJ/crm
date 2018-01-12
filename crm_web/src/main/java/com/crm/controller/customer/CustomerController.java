package com.crm.controller.customer;

import com.crm.framework.context.BaseController;
import com.crm.model.Customer;
import com.crm.model.CustomerOrder;
import com.crm.model.Datadic;
import com.crm.service.ICustomerService;
import com.crm.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController{

    @Autowired
    private ICustomerService customerService;

    //查询所有客户
    @RequestMapping("/queryAllCustomers")
    @ResponseBody
    public List<Customer> queryAllCustomers(){
        return customerService.queryAllCustomers();
    }

    //跳转到客户信息管理
    @RequestMapping("/index.shtml")
    public String index(){
        return "customer";
    }

    // 查询所有客户信息    条件查询共用
    @RequestMapping("/queryCustomersByParams")
    @ResponseBody
    public Map<String,Object> queryCustomersByParams(Customer customer) {

        return customerService.queryCustomersByParams(customer);
    }

    // 查询所有客户等级
    @RequestMapping("/queryDataDicValueByDataDicName")
    @ResponseBody
    public List<Datadic> queryDataDicValueByDataDicName(String dataDicName) {
        return customerService.queryDataDicValueByDataDicName(dataDicName);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResultInfo insertCustomer(Customer customer) {

        return customerService.insertCustomer(customer);
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultInfo updateCustomer(Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultInfo deleteCustomerById(Integer[] ids) {
        return customerService.deleteCustomerById(ids);
    }


    /**
     *
     * @param type  1，联系人管理   2，交往记录管理   3，历史订单查看
     * @param id
     * @return
     */
    @RequestMapping("/toOtherPage/{type}/{id}")
    @ResponseBody
    public ModelAndView toOtherPage(@PathVariable("type") Integer type,@PathVariable("id") Integer id){

        ModelAndView modelAndView = new ModelAndView();

        switch (type) {
            case 1:     //联系人管理
                modelAndView.setViewName("customer_linkman");
                break;
            case 2:     //交往记录管理
                modelAndView.setViewName("customer_contact");
                break;
            case 3:     //历史订单查看
                modelAndView.setViewName("customer_order");
                Customer customer = customerService.queryCustomerById(id);
                modelAndView.addObject("customer", customer);
                break;
            default:
                modelAndView.setViewName("500");
                break;
        }

        return modelAndView;
    }

}
