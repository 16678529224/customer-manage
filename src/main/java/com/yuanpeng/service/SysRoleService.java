package com.yuanpeng.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.yuanpeng.BuilderJava.Res;
import com.yuanpeng.BuilderJava.ReturnPage;
import com.yuanpeng.domain.SysRole;
import com.baomidou.mybatisplus.service.IService;
import com.yuanpeng.domain.SysUser;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-21
 */
public interface SysRoleService extends IService<SysRole> {
	Res saveSysRole( SysRole sysRole);
	public ReturnPage selRoleListPage(Page<SysRole> page);
	Res remove(String id);
}
