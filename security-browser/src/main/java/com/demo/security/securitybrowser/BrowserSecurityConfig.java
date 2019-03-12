package com.demo.security.securitybrowser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author : luofeng
 * @date : Created in 2019/3/12 10:44
 * @description :
 */
@Configuration
public class BrowserSecurityConfig  extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .and()
                .authorizeRequests()    //下面都是授权配置
                .anyRequest()           //任何请求
                .authenticated();       //都需要身份认证

    }
}
