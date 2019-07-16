package com.yuanpeng.test.serviceImpl;

import com.yuanpeng.domain.User;
import com.yuanpeng.test.mapper.TestMapper;
import com.yuanpeng.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Component
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
   @Autowired
   private JdbcTemplate jdbcTemplate;

    @Override
    public   List<Map<String, Object>> getUser (){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM sys_user ", new Object[]{});
        return list;
    }
    @Override
    public List<User> getAllSysUser(){
        List<User> list = testMapper.getAllSysUser();
        return list;
    }
}
