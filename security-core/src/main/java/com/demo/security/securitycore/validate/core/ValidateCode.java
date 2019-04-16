package com.demo.security.securitycore.validate.core;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : luofeng
 * @date : Created in 2019/3/21 16:44
 * @description :
 */

@Data
public class ValidateCode {

    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }


    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
