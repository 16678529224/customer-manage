package com.yuanpeng.mapper;

import com.yuanpeng.domain.SysPermission;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-28
 */
@Repository
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

}
