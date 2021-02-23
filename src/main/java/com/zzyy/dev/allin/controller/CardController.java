package com.zzyy.dev.allin.controller;

import com.zzyy.dev.allin.entity.House;
import com.zzyy.dev.allin.servie.CardService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Auther: zhouyu
 * @Date: 2021/2/23 16:28
 * @Description:
 */
@RequestMapping("/card")
public class CardController {


    @Resource
    CardService cardService;

    @RequestMapping("/getHouse")
    public House getHouse(){

        return cardService.getHouse();

    }

}
