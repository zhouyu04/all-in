package com.zzyy.dev.allin.entity;

import lombok.Data;

import java.util.List;

/**
 * @Auther: zhouyu
 * @Date: 2021/2/23 18:02
 * @Description:
 */
@Data
public class House {

    private long id;

    private int status;

    private long times;

    private long userId;

    private List<User> users;

    private String usernames;




}
