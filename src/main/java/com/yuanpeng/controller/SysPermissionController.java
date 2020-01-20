package com.yuanpeng.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.yuanpeng.BuilderJava.Res;
import com.yuanpeng.BuilderJava.ReturnPage;
import com.yuanpeng.domain.SysPermission;
import com.yuanpeng.domain.SysRole;
import com.yuanpeng.domain.SysUser;
import com.yuanpeng.service.SysPermissionService;
import com.yuanpeng.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-28
 */
@Controller
@RequestMapping("/sysPermission")
public class SysPermissionController {
	private final static Logger logger = LoggerFactory.getLogger(SysPermissionController.class);

	@Autowired
	SysPermissionService sysPermissionService;
	/**
	 * 权限管理页面
	 * @param model
	 * @param request
	 * @return
	 */
	@GetMapping("/permission/index")
	public String sysPermissionIndex(Model model, HttpServletRequest request){
		return "user/administrators/permission";
	}

	/**
	 * 权限管理增加页面
	 * @param model
	 * @param request
	 * @return
	 */
	@GetMapping("/permissionform/index")
	public String permissionformIndex(Model model, HttpServletRequest request){
		String value=request.getParameter("id");
		System.out.println(value);
		model.addAttribute("fatherid",value);
		return "user/administrators/permissionform";
	}

	/**
	 * 保存权限
	 * @param sysPermission
	 * @return
	 */
	@ResponseBody
	@PostMapping(value = "/saveSysPermission")
	public Res saveSysPermission(@ModelAttribute SysPermission sysPermission) {
		return sysPermissionService.saveSysPermission(sysPermission);
	}

	/**
	 * 查询所有权限信息,分页
	 *
	 * @return
	 */
	@GetMapping("/selPermissionListPage")
	@ResponseBody
	public ReturnPage selUserListPage(@ModelAttribute SysPermission sysPermission){
		Page<SysPermission> page = new Page<>(1,1000);
		if(!"father".equals(sysPermission.getId())){//不是父
			sysPermission.setParentId(sysPermission.getId());//父级id
		}else{
			sysPermission.setParentId("0");//父级id
		}
		ReturnPage retpage  = sysPermissionService.selUserListPage(page,sysPermission);
		return retpage;
	}
	@DeleteMapping("/remove/{id}")
	@ResponseBody
	public Res remove(@PathVariable String id) {
		return sysPermissionService.remove(id);

	}

}

