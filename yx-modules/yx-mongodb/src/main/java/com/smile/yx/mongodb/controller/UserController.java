package com.smile.yx.mongodb.controller;

import com.smile.yx.mongodb.entity.User;
import com.smile.yx.mongodb.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: qing.wang.o
 * @create: 2019-03-05 10:13
 **/
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @PostMapping
    public String save(@RequestBody User user) {
        log.info("user:{}", user);
        userService.save(user);
        return "";
    }
}
