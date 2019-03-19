package com.demo.security.securitybrowser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : luofeng
 * @date : Created in 2019/3/12 10:44
 * @description :
 */
@Configuration
public class BrowserSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        //如原有系统使用的MD5加密，那么需要自己实现PasswordEncoder接口
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .and()
                .authorizeRequests()    //下面都是授权配置
                .anyRequest()           //任何请求
                .authenticated();       //都需要身份认证

    }
}
