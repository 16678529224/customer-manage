package com.yuanpeng.BuilderJava;

import com.yuanpeng.domain.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

public class ToolUtils {
    //新建uuid ip+36uuid
    public  static  String getUuid (){
        String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();
        try {
            InetAddress addr = InetAddress.getLocalHost();
            String userip = addr.getHostAddress().replace(".","");
            return userip+uuid;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return  uuid ;
        }
    }
    //获取当前登陆ip
    public  static  String getIp(){
        try {
            InetAddress addr = InetAddress.getLocalHost();
            String userip = addr.getHostAddress();
            return userip;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return  "127.0.0.1" ;
        }
    }
    //获取当前登录人
    public  static SysUser getUser(){
        Subject Subject = SecurityUtils.getSubject();
        SysUser sysUser= (SysUser)Subject.getPrincipal();//SimpleAuthenticationInfo方法的第一个参数
        return sysUser;
    }
}
