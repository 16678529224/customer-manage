package com.yuanpeng.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.yuanpeng.BuilderJava.Res;
import com.yuanpeng.BuilderJava.ReturnPage;
import com.yuanpeng.domain.SysPermission;
import com.baomidou.mybatisplus.service.IService;
import com.yuanpeng.domain.SysRole;
import com.yuanpeng.domain.SysUser;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-28
 */
public interface SysPermissionService extends IService<SysPermission> {
	Res saveSysPermission(SysPermission sysPermission);
	ReturnPage selUserListPage(Page<SysPermission> page,SysPermission sysPermission);
	Res remove(String id);
}
