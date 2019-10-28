package com.yuanpeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
    @GetMapping("/console/index")
    public String consoleIndex(Model model){
        return "home/console";
    }
    @GetMapping("/homepage1/index")
    public String homepage1Index(Model model){
        return "home/homepage1";
    }
    @GetMapping("/homepage2/index")
    public String homepage2Index(Model model){
        return "home/homepage2";
    }
}
