package com.zzyy.dev.allin.entity;

import lombok.Data;

/**
 * @Auther: zhouyu
 * @Date: 2021/2/24 15:49
 * @Description:
 */
@Data
public class Score {

    private long id;

    private User user;

    private double score;
}
