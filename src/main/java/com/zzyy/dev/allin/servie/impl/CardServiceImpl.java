package com.zzyy.dev.allin.servie.impl;

import com.zzyy.dev.allin.entity.House;
import com.zzyy.dev.allin.mapper.CardMapper;
import com.zzyy.dev.allin.servie.CardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: zhouyu
 * @Date: 2021/2/23 18:04
 * @Description:
 */
@Service
public class CardServiceImpl implements CardService {

    @Resource
    CardMapper cardMapper;

    @Override
    public House getHouse() {
        return cardMapper.getHouse();
    }
}
