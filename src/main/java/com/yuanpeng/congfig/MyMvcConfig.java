package com.yuanpeng.congfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter; 之前是这个2.0后过时了,用WebMvcConfigurationSupport

/**
 * 视图解析器配置类,
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送 /atguigu 请求来到 success  视图映射,不用写Controller
        registry.addViewController("/asc").setViewName("test");
    }*/
    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webmvc = new WebMvcConfigurer(){
            //路径映射
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/login").setViewName("login/login");

            }
            //注册拦截器

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源；  *.css , *.js
                //SpringBoot已经做好了静态资源映射
                registry.addInterceptor(new MvcHandlerInterceptor()).addPathPatterns("/**").
                        excludePathPatterns("/login/*","/login",
                                            "/**/*.js","/**/*.css",
                                            "/**/*.woff","/**/*.ttf"
                                            );
               // registry.addInterceptor(new MvcHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return webmvc;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
