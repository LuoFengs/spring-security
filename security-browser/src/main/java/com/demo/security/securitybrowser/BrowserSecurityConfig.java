package com.demo.security.securitybrowser;

import com.demo.security.securitybrowser.authentication.MyAuthenticationFailureHandler;
import com.demo.security.securitycore.properties.SecurityProperties;
import com.demo.security.securitycore.validate.core.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author : luofeng
 * @date : Created in 2019/3/12 10:44
 * @description :
 */
@Configuration
public class BrowserSecurityConfig  extends WebSecurityConfigurerAdapter {


    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        //如原有系统使用的MD5加密，那么需要自己实现PasswordEncoder接口
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);

        http.addFilterBefore(validateCodeFilter,UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)
                .and()
                .authorizeRequests()    //下面都是授权配置
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage(),
                        "/code/image").permitAll()
                .anyRequest()           //任何请求
                .authenticated()        //都需要身份认证
                .and()
                .csrf().disable();

    }
}
