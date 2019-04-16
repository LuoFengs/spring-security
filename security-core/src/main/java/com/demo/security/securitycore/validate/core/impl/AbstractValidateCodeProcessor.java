package com.demo.security.securitycore.validate.core.impl;

import com.demo.security.securitycore.validate.ValidateCodeProcessor;
import com.demo.security.securitycore.validate.core.ValidateCode;
import com.demo.security.securitycore.validate.core.ValidateCodeGenerator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * @author : luofeng
 * @date : Created in 2019/4/16 15:15
 * @description : 校验码处理器，封装不同校验码的处理逻辑
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    /**
     * 操作session的工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    /**
     * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;


    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generate(request);
        save(request,validateCode);
        send(request,validateCode);
    }

    /**
     * 生成校验码
     */
    private C generate(ServletWebRequest request){
        String type = getProcessorType(request);
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(type + "ValidateCodeGenerator");
        return (C)validateCodeGenerator.generator(request);
    }

    /**
     * 保存校验码
     */
    private void save(ServletWebRequest request,C validateCode){
        sessionStrategy.setAttribute(request,SESSION_KEY_PREFIX+getProcessorType(request).toUpperCase(),validateCode);
    }

    /**
     * 发送验证码，由子类实现
     */
    protected abstract void send(ServletWebRequest request,C validateCode) throws Exception;


    /**
     * 根据请求url获取校验码类型
     */
    private String getProcessorType(ServletWebRequest request){
        return StringUtils.substringAfter(request.getRequest().getRequestURI(),"/code/");
    }

}
