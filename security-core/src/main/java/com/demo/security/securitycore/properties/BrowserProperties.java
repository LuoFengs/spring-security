package com.demo.security.securitycore.properties;

import lombok.Data;

/**
 * @author : luofeng
 * @date : Created in 2019/3/19 17:27
 * @description :
 */
@Data
public class BrowserProperties {

    private String loginPage = "/signIn.html";

    private LoginType loginType = LoginType.JSON;

    private int rememberMeSeconds = 3600;


}
