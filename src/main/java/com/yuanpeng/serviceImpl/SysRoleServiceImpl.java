package com.yuanpeng.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yuanpeng.BuilderJava.Res;
import com.yuanpeng.BuilderJava.ReturnPage;
import com.yuanpeng.BuilderJava.TimeUtil;
import com.yuanpeng.domain.SysPermission;
import com.yuanpeng.domain.SysRole;
import com.yuanpeng.domain.SysUser;
import com.yuanpeng.mapper.SysRoleMapper;
import com.yuanpeng.service.SysRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-21
 */
@Service
@Transactional(readOnly = true)
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
	private static final Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);

	@Override
	@Transactional
	public Res saveSysRole(SysRole sysRole) {
		//sysRole.setCreateTime(TimeUtil.dateFormat(new Date()));
		this.baseMapper.insert(sysRole);
		return new Res();
	}

	@Override
	public ReturnPage selRoleListPage(Page<SysRole> page){
		List<SysRole> list  =  this.baseMapper.selectPage(page,new EntityWrapper<SysRole>().eq("del_flag",0));
		//logger.debug(new ReturnPage(list,page).toString());
		return new ReturnPage(list,page);
	}

	@Override
	@Transactional
	public Res remove(String id){
		SysRole sysRole = new SysRole();
		sysRole.setId(id);
		sysRole.setDelFlag(1);
		this.baseMapper.updateById(sysRole);
		//this.baseMapper.deleteById(id);
		return new Res();
	}
}
