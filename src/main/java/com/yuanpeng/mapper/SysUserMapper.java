package com.yuanpeng.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yuanpeng.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-05
 */
@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    //创建用户
    Integer insertSysUser(SysUser sysUser);
    //根据手机号查有几个用户
    Integer selcetMobileBySysUserNum(String mobile);
    //根据手机号查有几个用户
    Integer selcetUserNameBySysUserNum(String username);
	//根据手机号查用户
	SysUser contrastMobile(SysUser sysUser);
    //根据用户名查用户
    SysUser contrastUserName(String username);
    //查询所有用户信息,分页

}
