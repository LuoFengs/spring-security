package com.demo.security.securitycore;

import com.demo.security.securitycore.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author : luofeng
 * @date : Created in 2019/3/19 17:30
 * @description :
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
