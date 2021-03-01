package com.zzyy.dev.allin.servie;

import com.alibaba.fastjson.JSONObject;
import com.zzyy.dev.allin.entity.House;
import com.zzyy.dev.allin.entity.User;

/**
 * @Auther: zhouyu
 * @Date: 2021/2/23 18:04
 * @Description:
 */
public interface CardService {


    House getHouse();

    String joinHouse(long num, User user);

    String addHouse(long time, User user);

    JSONObject getRecord(long num);

    String edit(JSONObject param);

    int getMaxIndex(long num, long id);
}
