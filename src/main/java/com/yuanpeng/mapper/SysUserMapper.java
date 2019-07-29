package com.yuanpeng.mapper;

import com.yuanpeng.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper
{
	//创建用户
    Integer insertSysUser(SysUser sysUser);
    //根据手机号查有几个用户
    Integer selcetMobileBySysUserNum(String mobile);
    //根据手机号查有几个用户
    Integer selcetUserNameBySysUserNum(String username);

	//根据手机号查用户
	SysUser contrastMobile(SysUser sysUser);

}
