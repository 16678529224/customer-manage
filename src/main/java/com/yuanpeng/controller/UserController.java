package com.yuanpeng.controller;

import com.yuanpeng.domain.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("/list/index")
    public String listIndex(Model model, HttpServletRequest request){
        return "user/list";
    }
    @GetMapping("/userform/index")
    public String userformIndex(Model model, HttpServletRequest request){
        return "user/userform";
    }



}
