package com.smile.yx.monitor;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * springboot admin监控
 * @author qing.wang.o
 */
@EnableAdminServer
@EnableTurbine
@EnableDiscoveryClient
@SpringCloudApplication
public class YxMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(YxMonitorApplication.class, args);
    }
}
