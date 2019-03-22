package com.demo.security.securitycore.validate.core;


import org.springframework.security.core.AuthenticationException;

/**
 * @author : luofeng
 * @date : Created in 2019/3/21 17:13
 * @description :
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
