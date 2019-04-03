package com.demo.security.securitycore.validate.core;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author : luofeng
 * @date : Created in 2019/4/3 14:40
 * @description :
 */
public interface ValidateCodeGenerator {

    ImageCode generator(ServletWebRequest request);

}
