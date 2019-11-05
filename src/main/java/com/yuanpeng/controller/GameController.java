package com.yuanpeng.controller;

import com.yuanpeng.game.Rain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("game")
public class GameController {
    @GetMapping("/rain")
    public void rainIndex(Model model){
        //Run->Edit Configurations/config/VM -Djava.awt.headless=false
        //更改虚拟机
        new Rain();
    }
    @GetMapping("/shu")
    public String shuIndex(Model model){

        return "game/shu/index";
    }
    @GetMapping("/heidong")
    public String heidongIndex(Model model){

        return "game/heidong/index";
    }
}
