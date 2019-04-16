package com.demo.security.securitycore.properties;

import lombok.Data;

/**
 * @author : luofeng
 * @date : Created in 2019/4/3 11:04
 * @description :
 */
@Data
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

}
