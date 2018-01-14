package com.crm.controller.customer;

import com.crm.service.ICustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/customer_order")
@Controller
public class CustomerOrderController {

    @Autowired
    private ICustomerOrderService customerOrderService;

    /**
     * @param cid
     * @param page 分页参数
     * @param rows 分页参数
     * @return
     */
    @RequestMapping("/queryOrdersByCid")
    @ResponseBody
    public Map<String, Object> queryOrdersByCid(@RequestParam("cid")Integer cid,
                                                @RequestParam(defaultValue = "1") Integer page,
                                                @RequestParam(defaultValue = "10") Integer rows) {

        return customerOrderService.queryOrdersByCid(cid, page, rows);
    }

    @PostMapping("/queryCustoemrOrderByOrderId")
    @ResponseBody
    public Map<String, Object> queryCustoemrOrderByOrderId(@RequestParam("orderId") Integer orderId,
                                                            @RequestParam(defaultValue = "1") Integer page,
                                                            @RequestParam(defaultValue = "10") Integer rows) {

        return customerOrderService.queryCustoemrOrderByOrderId(orderId, page, rows);
    }


}
