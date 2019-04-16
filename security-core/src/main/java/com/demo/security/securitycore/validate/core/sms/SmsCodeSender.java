package com.demo.security.securitycore.validate.core.sms;

/**
 * @author : luofeng
 * @date : Created in 2019/4/16 11:17
 * @description :   短信验证码
 */
public interface SmsCodeSender {

    void send(String mobile,String code);

}
