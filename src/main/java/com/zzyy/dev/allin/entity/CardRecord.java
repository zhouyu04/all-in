package com.zzyy.dev.allin.entity;

import lombok.Data;

import java.util.List;

/**
 * @Auther: zhouyu
 * @Date: 2021/2/24 15:48
 * @Description:
 */
@Data
public class CardRecord {


    private long id;

    private long houseId;

    private long index;

    private List<Score> scores;

}
