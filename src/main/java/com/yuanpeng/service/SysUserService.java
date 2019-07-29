package com.yuanpeng.service;

import com.yuanpeng.BuilderJava.Res;
import com.yuanpeng.domain.SysUser;

import javax.servlet.http.HttpServletRequest;

public interface SysUserService
{
    //注册
	public Res saveSysUser(SysUser sysUser);
	//登录
	public Res login(SysUser sysUser,HttpServletRequest request);

	public SysUser contrastMobile(String str);

}
