package com.demo.security.securitycore.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author : luofeng
 * @date : Created in 2019/4/16 11:47
 * @description : 校验码处理器，封装不同校验码的处理逻辑
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";


    /**
     * 创建校验码
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

}
