package com.demo.security.securitycore.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : luofeng
 * @date : Created in 2019/3/19 17:26
 * @description :
 */
@ConfigurationProperties(prefix = "demo.security")
@Data
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

}
