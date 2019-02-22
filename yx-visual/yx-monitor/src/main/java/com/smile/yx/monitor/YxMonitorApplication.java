package com.smile.yx.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * springboot admin监控
 * @author qing.wang.o
 */
//@EnableAdminServer
//@EnableTurbine
@EnableDiscoveryClient
@SpringCloudApplication
public class YxMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(YxMonitorApplication.class, args);
    }
}
