package com.yuanpeng.controller;

import com.yuanpeng.BuilderJava.ToolUtils;
import com.yuanpeng.domain.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("index")
public class IndexController {
    @GetMapping("/index")
    public String index(Model model, HttpServletRequest request){
        SysUser user = ToolUtils.getUser();
        model.addAttribute("loginName",user.getNickname());
        return "index/index";
    }
}
