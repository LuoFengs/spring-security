package com.demo.security.securitycore.properties;

import lombok.Data;

/**
 * @author : luofeng
 * @date : Created in 2019/4/3 11:02
 * @description :
 */

@Data
public class ImageCodeProperties {

    private int width = 67;
    private int height = 67;
    private int length = 67;
    private int expireIn = 60;

    private String url;



}
