package com.smile.yx.mongodb.repository;

import com.smile.yx.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @description:
 * @author: qing.wang.o
 * @create: 2019-03-05 10:07
 **/
public interface UserRepository extends MongoRepository<User, Long> {

    User findByName(String name);

}
