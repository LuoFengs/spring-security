package com.demo.security.securitycore.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author : luofeng
 * @date : Created in 2019/3/21 16:49
 * @description :
 */
@RestController
public class ValidateCodeController {

    public final static String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    @GetMapping("/code/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
        validateCodeProcessors.get(type+"ValidateCodeProcessor").create(new ServletWebRequest(request,response));
    }


}
