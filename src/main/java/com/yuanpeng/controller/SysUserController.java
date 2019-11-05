package com.yuanpeng.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-05
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {
    /**.
     * 网站用户
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/list/index")
    public String listIndex(Model model, HttpServletRequest request){
        return "user/list";
    }
    @GetMapping("/userform/index")
    public String userformIndex(Model model, HttpServletRequest request){
        return "user/userform";
    }
    @GetMapping("/administrators/adminform/index")
    public String administratorsAdminform(Model model, HttpServletRequest request){
        return "user/administrators/adminform";
    }

    /**
     * 后台管理员
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/administrators/list/index")
    public String administratorsList(Model model, HttpServletRequest request){
        return "user/administrators/list";
    }

    /**
     * 角色管理
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/administrators/role/index")
    public String administratorsRole(Model model, HttpServletRequest request){
        return "user/administrators/role";
    }
    @GetMapping("/administrators/roleform/index")
    public String administratorsRoleform(Model model, HttpServletRequest request){
        return "user/administrators/roleform";
    }
}

