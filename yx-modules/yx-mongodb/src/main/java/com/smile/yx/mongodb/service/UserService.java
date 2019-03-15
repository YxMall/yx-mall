package com.smile.yx.mongodb.service;

import com.smile.yx.mongodb.entity.User;
import com.smile.yx.mongodb.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: qing.wang.o
 * @create: 2019-03-05 10:14
 **/
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void save(User user) {
        repository.save(user);
    }

}
