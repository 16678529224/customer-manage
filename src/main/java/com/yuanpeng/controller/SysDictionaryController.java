package com.yuanpeng.controller;


import com.yuanpeng.service.SysDictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 系统字典表 前端控制器
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-22
 */
@Controller
@RequestMapping("/sysDictionary")
public class SysDictionaryController {
    private final static Logger logger = LoggerFactory.getLogger(SysDictionaryController.class);
    @Autowired
    SysDictionaryService sysDictionaryService;
    /**.
     * 网站用户
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/dictionary/index")
    public String listIndex(Model model, HttpServletRequest request){
        return "user/administrators/dictionary";
    }

}

