package com.smile.yx.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author qing.wang.o
 */
@EnableZuulProxy
@SpringCloudApplication
public class YxGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(YxGatewayApplication.class, args);
    }
}
