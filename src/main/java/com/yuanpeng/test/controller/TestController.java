package com.yuanpeng.test.controller;

import com.yuanpeng.domain.User;
import com.yuanpeng.test.service.TestService;
import javafx.beans.property.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.net.URL;
import java.util.*;

@Controller
public class TestController {
    @Autowired
    private TestService testService;
    @GetMapping("/test5")
    public String test5(Model model){
        List<Map<String, Object>> user = testService.getUser();
        model.addAttribute("email",user);
        return "test";
    }
    @GetMapping("/test6")
    public String test6(Model model){
        List<User> user = testService.getAllSysUser();
        model.addAttribute("email",user.get(0).getName());
        return "test";
    }
    @RequestMapping("/test")
    public String index2(){
        return "test";
    }

    @RequestMapping("/test1")
    public ModelAndView index1 ()throws IOException {
        ModelAndView modelAndView = new ModelAndView();

        /*Thread.currentThread().getContextClassLoader();
        URL url = Thread.currentThread().getContextClassLoader().getResource("/static/messages/messages_CN.properties");
        String urlStr=url.getPath();*/
        Properties props = new Properties();
        Map<String,String> map = new HashMap<>();
        InputStream  in = null;
        String Property = null;
        try {
            //in = new FileInputStream(urlStr);
            in = TestController.class.getClass().getResourceAsStream("/static/messages/messages_zh_CN.properties");
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            props.load(bf);
            String key = "AA0708";//key值
            Property = new String(props.getProperty(key));//value值
            System.out.println(key+"====="+Property);
        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            if (null != in)
                in.close();
        }
        modelAndView.addObject("email", Property);
        modelAndView.setViewName("test");
        return modelAndView;
    }
    @GetMapping({"/","/beetl"})
    public String beetl(Model model){
        model.addAttribute("email","测试一下");
        return "test";
    }
    @GetMapping("/index")
    public String index(){
       // model.addAttribute("email","测试一下");
        return "index";
    }
    @GetMapping("/console")
    public String console(){
        // model.addAttribute("email","测试一下");
        return "home/console";
    }
    @GetMapping("/homepage1")
    public String homepage1(){
        // model.addAttribute("email","测试一下");
        return "home/homepage1";
    }
    @GetMapping("/homepage2")
    public String homepage2(){
        // model.addAttribute("email","测试一下");
        return "home/homepage2";
    }
    @GetMapping("/getuser")
    public String getuser(){
        // model.addAttribute("email","测试一下");
        return "home/homepage2";
    }

}
