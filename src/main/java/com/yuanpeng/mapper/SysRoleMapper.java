package com.yuanpeng.mapper;

import com.yuanpeng.domain.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-21
 */
@Repository
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

}
