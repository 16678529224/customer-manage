package com.yuanpeng.test.mapper;

import com.yuanpeng.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    public List<User> getAllSysUser();
}
