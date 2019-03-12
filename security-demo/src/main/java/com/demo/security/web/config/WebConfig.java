package com.demo.security.web.config;

import com.demo.security.web.filter.TimeFilter;
import com.demo.security.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TimeInterceptor timeInterceptor;

    //异步方法注册拦截器
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        configurer.registerCallableInterceptors()

    }

    //同步方法注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        bean.setFilter(timeFilter);
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        bean.setUrlPatterns(urls);
        return  bean;
    }

}
