package com.crm.controller.user;

import com.crm.model.User;
import com.crm.service.IUserService;
import com.crm.utils.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/userLogin")
    @ResponseBody
    public ResultInfo userLogin(@RequestParam(defaultValue = "") String userName,
                                @RequestParam(defaultValue = "")String userPwd){
        System.out.println(userName);
        System.out.println(userPwd);

       return userService.userLogin(userName, userPwd);

    }

    //查询所有分配人
    @RequestMapping("/queryAllCustomerManager")
    @ResponseBody
    public List<User> queryAllCustomerManager(){
        return userService.queryAllCustomerManager();
    }

}
