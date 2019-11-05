package com.yuanpeng.congfig;


import com.yuanpeng.congfig.shiro.ShiroExt;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.beetl.ext.web.WebVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.baomidou.mybatisplus.generator.config.*;

@Configuration
public class BeetlConfig {

    @Value("${beetl.templatesPath}") String templatesPath;//模板根目录 ，比如 "templates"
    @Autowired
    ReadProperties readProperties;
    @Autowired
    private WebApplicationContext wac;

    @Bean(name = "beetlCon")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        ClasspathResourceLoader classpathResourceLoader = new ClasspathResourceLoader();
        beetlGroupUtilConfiguration.setResourceLoader(classpathResourceLoader);
        beetlGroupUtilConfiguration.init();
        return beetlGroupUtilConfiguration;

    }

    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlCon") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setPrefix(templatesPath);
        beetlSpringViewResolver.setSuffix(".html");
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }
    @Bean
    public GroupTemplate getGroupTemplate(BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) throws IOException {
        GroupTemplate gt = beetlGroupUtilConfiguration.getGroupTemplate();
        Map<String,Object> shared = new HashMap<>();

        //测试
        shared.put("blogSiteTitle",templatesPath);
        gt.setSharedVars(shared);
        // 注册国家化函数
        gt.registerFunction("i18n", new I18nFunction(wac));
        //注册shiro
        gt.registerFunctionPackage("so", new ShiroExt());
        return gt;
    }

    public class I18nFunction implements Function {
        private WebApplicationContext wac;
        public I18nFunction(WebApplicationContext wac) {
            this.wac = wac;
        }
        @Override
        public Object call(Object[] obj, Context context) {
            HttpServletRequest request = (HttpServletRequest) context.getGlobal(WebVariable.REQUEST);
            RequestContext requestContext = new RequestContext(request);
            String message = requestContext.getMessage((String) obj[0]);
            return message;
        }

    }




}

