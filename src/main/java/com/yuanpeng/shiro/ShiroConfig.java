package com.yuanpeng.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration//表明配置类
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean(name = "ShiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){//qualifier的意思是合格者，通过这个标示，表明了哪个实现类才是我们所需要的
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器:可以实现权限相关的拦截器
        /**
         * 常用过滤器:
         * anon:无需认证可以访问
         * authc:必须认证可以访问
         * user:如果使用rememberMe的功能可以直接访问
         * perms:该资源必须授予资源权限才可以访问
         * role:该资源必须得到角色授权才可以访问
         */

        Map<String,String> filterMap = new LinkedHashMap<String,String>();
        /**
         * 这里有个优先级问题,先设置小再设置大
         */
        filterMap.put("/**/*.js","anon");
        filterMap.put("/**/*.css","anon");
        filterMap.put("/**/*.woff","anon");
        filterMap.put("/**/*.ttf","anon");
        filterMap.put("/login/*","anon");
        filterMap.put("/login","anon");
        filterMap.put("/","anon");
        filterMap.put("/druid","anon");
        filterMap.put("/druid/*","anon");
        filterMap.put("/shiro/logout","logout");



        filterMap.put("/home/homepage1/index", "perms[index:index]");//页面拦截可以不显示页面但是路径还是能进去所以要拦截所有路径


        filterMap.put("/**","authc");
        //修改拦截后跳转页面
        shiroFilterFactoryBean.setLoginUrl("/");
        //设置未授权提示页面
        //shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);


        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager  安全管理器(关联Realm:连接数据的桥梁)
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){//qualifier的意思是合格者，通过这个标示，表明了哪个实现类才是我们所需要的
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    /**
     *Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }



}
