package com.demo.security.securitycore.validate.core.sms;

/**
 * @author : luofeng
 * @date : Created in 2019/4/16 11:19
 * @description :
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机"+mobile+"发送短信验证码"+code);
    }

}
