package com.demo.security.securitycore.properties;

import lombok.Data;

/**
 * @author : luofeng
 * @date : Created in 2019/4/3 11:02
 * @description :
 */

@Data
public class SmsCodeProperties {

    private int length = 6;
    private int expireIn = 60;

    private String url;


}
