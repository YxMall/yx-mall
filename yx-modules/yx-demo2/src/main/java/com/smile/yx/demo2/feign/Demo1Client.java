package com.smile.yx.demo2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description: demo fegin
 * @author: qing.wang.o
 * @create: 2019-02-19 14:18
 **/
@FeignClient("yx-demo1")
public interface Demo1Client {


    /**
     * 调用dem1服务接口
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String demo1Hello();
}
