package com.demo.security.securitycore.validate.core;

import com.demo.security.securitycore.properties.SecurityProperties;
import com.demo.security.securitycore.validate.core.image.ImageCodeGenerator;
import com.demo.security.securitycore.validate.core.sms.DefaultSmsCodeSender;
import com.demo.security.securitycore.validate.core.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : luofeng
 * @date : Created in 2019/4/3 14:48
 * @description :
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator(){
        ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
        imageCodeGenerator.setSecurityProperties(securityProperties);
        return imageCodeGenerator;
    }



    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeGenerator(){
        return new DefaultSmsCodeSender();
    }

}
