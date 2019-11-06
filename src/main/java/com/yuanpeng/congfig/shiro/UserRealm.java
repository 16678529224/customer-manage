package com.yuanpeng.congfig.shiro;

import com.yuanpeng.BuilderJava.PasswordEncryption;
import com.yuanpeng.domain.SysUser;
import com.yuanpeng.mapper.SysUserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * 自定义Realm  Realm:Shiro链接数据的桥梁
 */
public class UserRealm extends AuthorizingRealm {
    private final static Logger logger = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    private SysUserMapper sysUserMapper;


    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.debug("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //获取当前登陆用户
        Subject Subject = SecurityUtils.getSubject();
        SysUser sysUser= (SysUser)Subject.getPrincipal();//SimpleAuthenticationInfo方法的第一个参数

        //添加资源的授权字符串
        info.addStringPermission("index:index");

        return info;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.debug("执行认证逻辑");
        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        SysUser sysUser = sysUserMapper.contrastUserName(username);
        if(sysUser == null){
            //用户名不存在
            return null;//shiro底层会抛出UnKnowAccountException
        }
        if(sysUser.getStatus() == 1){

            throw new LockedAccountException();
        }
        //2.判断密码
        String  password  =  String.valueOf(token.getPassword());
        String encryptedAttemptedPassword =null;
        try {
             encryptedAttemptedPassword = PasswordEncryption.getEncryptedPassword(password, sysUser.getSalt());
            token.setPassword(encryptedAttemptedPassword.toCharArray());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        logger.debug("加密后的密码========"+encryptedAttemptedPassword);
        return new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),getName());
    }
}
