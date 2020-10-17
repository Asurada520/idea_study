package com.jade.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Redirect 工程测试
 */

@Controller
public class RedirectController {

    @RequestMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(String username, String password) {
        return "用户名：" + username + ", 密码：" + password;
    }

    /**
     * redirect 重定向 到 登陆
     * @return 登陆地址
     */
    @RequestMapping("/redirectPage")
    public String redirectPage(){
        return "redirect:/loginPage";
    }

    @RequestMapping("/payPage")
    public String payPage(){
        return "payPage";
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @ResponseBody
    public Object pay(long money){
        float moneyF = money/100;
        return money + " 元";
    }

}
