package com.smile.yx.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @description: 用户
 * @author: qing.wang.o
 * @create: 2019-03-05 10:05
 **/
@Data
public class User {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private Character gender;
    private Date birthday;
}
