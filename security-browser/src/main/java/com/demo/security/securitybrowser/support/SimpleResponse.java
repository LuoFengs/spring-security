package com.demo.security.securitybrowser.support;

import lombok.Data;

/**
 * @author : luofeng
 * @date : Created in 2019/3/19 17:18
 * @description :
 */
@Data
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }
}
