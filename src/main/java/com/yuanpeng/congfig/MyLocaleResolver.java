package com.yuanpeng.congfig;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 语言设置
 * 可以在连接上携带区域信息
 * 对于LocaleResolver，其主要作用在于根据不同的用户区域展示不同的视图，而用户的区域也称为Locale，该信息是可以由前端直接获取的。
 * 通过这种方式，可以实现一种国际化的目的，比如针对美国用户可以提供一个视图，而针对中国用户则可以提供另一个视图。本文主要讲解
 * 如果使用LocaleResolver来实现对用户不同视图切换的目的。
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = (String)request.getSession().getAttribute("lang");

        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(lang)){
            String[] split = lang.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }





}
