package com.yuanpeng.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yuanpeng.BuilderJava.Res;
import com.yuanpeng.BuilderJava.ReturnPage;
import com.yuanpeng.domain.SysPermission;
import com.yuanpeng.domain.SysUser;
import com.yuanpeng.mapper.SysPermissionMapper;
import com.yuanpeng.service.SysPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-28
 */
@Service
@Transactional(readOnly = true)
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

	@Override
	@Transactional
	public Res saveSysPermission(SysPermission sysPermission) {
		this.baseMapper.insert(sysPermission);
		return new Res();
	}

	@Override
	public ReturnPage selUserListPage(Page<SysPermission> page, SysPermission sysPermission) {
		String parentId=sysPermission.getParentId();
		List<SysPermission> list  =  this.baseMapper.selectPage(page,new EntityWrapper<SysPermission>().eq("del_flag",0)
																										.eq("parent_id",parentId));
		return new ReturnPage(list,page);
	}
	@Override
	@Transactional
	public Res remove(String id){
		SysPermission sysPermission = new SysPermission();
		sysPermission.setId(id);
		sysPermission.setDelFlag(1);
		this.baseMapper.updateById(sysPermission);
		//this.baseMapper.deleteById(id);
		return new Res();
	}
}
