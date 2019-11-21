package com.yuanpeng.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-21
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {
    /**
     * 角色管理
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/role/index")
    public String administratorsRole(Model model, HttpServletRequest request){
        return "user/administrators/role";
    }
    /*
    *
    * 添加角色页面
     */
    @GetMapping("/roleform/index")
    public String administratorsRoleform(Model model, HttpServletRequest request){
        return "user/administrators/roleform";
    }


}

