package com.crm.controller.index;

import com.crm.framework.context.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController{

    /**
     *  登录界面
     * @return
     */
    @GetMapping("/index.shtml")
    public String index(){
        return "index";
    }

    /**
     *  主页
     * @return
     */
    @GetMapping("/main.shtml")
    public String main(){
        return "main";
    }


}
