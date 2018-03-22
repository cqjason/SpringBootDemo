package com.springSecurityDemo.controller;

import com.springSecurityDemo.model.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jason on 2018/3/19.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String root(Model model){
        Msg msg = new Msg("标题", "内容", "额外信息，只对管理员显示");
        model.addAttribute("msg",msg);
        return "redirect:index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        model.addAttribute("errorMsg","登录失败");
        return "login";
    }
}
