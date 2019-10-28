package com.yuanpeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("set")
public class SetController {
    @GetMapping("/user/info/index")
    public String listIndex(Model model, HttpServletRequest request){
        return "/set/user/info";
    }
    @GetMapping("/user/password/index")
    public String userformIndex(Model model, HttpServletRequest request){
        return "set/user/password";
    }
}
