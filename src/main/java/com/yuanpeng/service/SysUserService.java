package com.yuanpeng.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.yuanpeng.BuilderJava.Res;
import com.yuanpeng.BuilderJava.ReturnPage;
import com.yuanpeng.domain.SysUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-05
 */
public interface SysUserService extends IService<SysUser> {
	//注册
	public Res saveSysUser(SysUser sysUser);
	//登录
	public Res login(SysUser sysUser, HttpServletRequest request);

	public SysUser contrastMobile(String str);
	public ReturnPage selUserListPage(Page<SysUser> page);
}
