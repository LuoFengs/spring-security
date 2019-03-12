package com.demo.security.wiremock;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @author : luofeng
 * @date : Created in 2019/3/4 14:51
 * @description :
 */
public class MockServer {


    public static void main(String[] args) throws IOException {

        configureFor(8062);   //通过端口连接服务
        removeAllMappings();  //清空之前的配置

//        stubFor(get(urlEqualTo("/order/1")).willReturn(aResponse().withBody("{\"id\":1}").withStatus(200)));

        mock("/order/1","01");

    }

    private static void mock(String url,String file) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/response/" + file + ".txt");
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "\n");
        stubFor(get(urlPathEqualTo(url)).willReturn(aResponse().withBody(content).withStatus(200)));
    }

}
