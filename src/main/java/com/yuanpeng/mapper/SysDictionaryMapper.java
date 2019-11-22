package com.yuanpeng.mapper;

import com.yuanpeng.domain.SysDictionary;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统字典表 Mapper 接口
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-22
 */
@Repository
@Mapper
public interface SysDictionaryMapper extends BaseMapper<SysDictionary> {

}
