package com.yuanpeng.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.yuanpeng.BuilderJava.Res;
import com.yuanpeng.BuilderJava.ResultCode;
import com.yuanpeng.BuilderJava.ReturnPage;
import com.yuanpeng.domain.SysRole;
import com.yuanpeng.domain.SysUser;
import com.yuanpeng.service.SysRoleService;
import com.yuanpeng.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
	private final static Logger logger = LoggerFactory.getLogger(SysRoleController.class);

	@Autowired
	SysRoleService sysRoleService;
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
        return "user/administrators/roleAndPermission";
    }
    //保存角色
	@ResponseBody
	@PostMapping(value = "/saveSysRole")
	public Res saveSysRole(@ModelAttribute SysRole sysRole) {
		return sysRoleService.saveSysRole(sysRole);
	}
	/**
	 * 查询所有用户信息,分页
	 *
	 * @return
	 */
	@GetMapping("/selRoleListPage")
	@ResponseBody
	public ReturnPage selRoleListPage(@ModelAttribute SysRole sysRole){
		Page<SysRole> page = new Page<>(sysRole.getPage(),sysRole.getLimit());
		//returnPage.getLimit();
		//logger.debug(sysUser.getPage()+"");
		ReturnPage retpage  = sysRoleService.selRoleListPage(page);
		return retpage;
	}
	@DeleteMapping("/remove/{id}")
	@ResponseBody
	public Res remove(@PathVariable String id) {
		return sysRoleService.remove(id);

	}

}

