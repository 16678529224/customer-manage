package com.yuanpeng.test.service;

import com.yuanpeng.domain.User;

import java.util.List;
import java.util.Map;

public interface TestService  {
    List<Map<String, Object>> getUser ();
    List<User> getAllSysUser();
}
