package com.yuanpeng.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.yuanpeng.BuilderJava.ReturnPage;
import com.yuanpeng.domain.SysUser;
import com.yuanpeng.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    private final static Logger logger = LoggerFactory.getLogger(SysUserController.class);
    @Autowired
    SysUserService sysUserService;
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
    /**
     * 网站用户里的编辑页面
     **/
    @GetMapping("/userform/index")
    public String userfromIndex(Model model, HttpServletRequest request){
        return "user/userform";
    }
    /**
     * 查询所有用户信息,分页
     *
     * @return
     */
    @GetMapping("/list/selUserListPage")
    @ResponseBody
    public ReturnPage selUserListPage(@ModelAttribute SysUser sysUser){
        Page<SysUser> page = new Page<>(sysUser.getPage(),sysUser.getLimit());

        //returnPage.getLimit();
        //logger.debug(sysUser.getPage()+"");
        ReturnPage retpage  = sysUserService.selUserListPage(page);


        return retpage;
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

