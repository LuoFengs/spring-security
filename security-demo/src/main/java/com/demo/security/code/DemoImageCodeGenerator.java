package com.demo.security.code;

import com.demo.security.securitycore.validate.core.ImageCode;
import com.demo.security.securitycore.validate.core.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author : luofeng
 * @date : Created in 2019/4/3 15:00
 * @description :
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generator(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成器");
        return null;
    }
}
