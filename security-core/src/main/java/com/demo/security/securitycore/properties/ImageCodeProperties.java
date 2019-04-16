package com.demo.security.securitycore.properties;

import lombok.Data;

/**
 * @author : luofeng
 * @date : Created in 2019/4/3 11:02
 * @description :
 */

@Data
public class ImageCodeProperties extends SmsCodeProperties{

    private int width = 67;
    private int height = 23;

    public ImageCodeProperties() {
        setLength(4);
    }
}
