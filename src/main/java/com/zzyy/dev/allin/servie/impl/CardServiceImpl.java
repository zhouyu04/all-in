package com.zzyy.dev.allin.servie.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zzyy.dev.allin.entity.CardRecord;
import com.zzyy.dev.allin.entity.House;
import com.zzyy.dev.allin.entity.Score;
import com.zzyy.dev.allin.entity.User;
import com.zzyy.dev.allin.mapper.CardMapper;
import com.zzyy.dev.allin.servie.CardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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

        House house = cardMapper.getHouse();
        if (house == null) {
            return new House();
        }

        List<User> users = house.getUsers();

        StringBuffer sb = new StringBuffer();

        for (User u : users) {
            String nickname = u.getNickname();
            sb.append(nickname + ",");
        }


        house.setUsernames(StringUtils.removeEnd(sb.toString(), ","));

        return house;
    }

    @Override
    public String joinHouse(long num, User user) {

        int i = cardMapper.checkIsActive(num);
        if (i == 0) {
            return "房间不存在或者已开始";
        }
        long userId = user.getId();
        //校验房间人数和是否已存在
        List<User> users = cardMapper.getHouseUser(num);
        //当前用户存在其中，直接进入用户中
        for (User u : users) {
            if (userId == u.getId()) {
                return "ok";
            }
        }

        if (users.size() == 3) {
            return "人数已到限制";
        }

        //然后在中间表添加记录
        cardMapper.joinHouse(num, user.getId());
        return "ok";
    }

    @Override
    @Transactional
    public String addHouse(long time, User user) {

        //检查是否有房间
        int i = cardMapper.checkExist();
        if (i > 0) {
            return "存在未开始房间,请直接加入";
        }

        //创建未开始房间，并添加中间表记录
        House house = new House();
        house.setTimes(time);
        house.setUserId(user.getId());
        cardMapper.createHouse(house);
        long num = house.getId();
        //房主加入房间
        cardMapper.joinHouse(num, user.getId());

        return "ok";
    }

    @Override
    public JSONObject getRecord(long num) {


        List<CardRecord> records = cardMapper.getRecord(num);

        JSONObject res = new JSONObject();
        JSONArray array = new JSONArray();
        res.put("page", 1);
        res.put("total", 1);
        res.put("rows", array);
        if (CollectionUtils.isEmpty(records)) {
            res.put("records", 0);
            return res;
        }
        res.put("records", records.size());

        for (CardRecord record : records) {
            JSONObject row = new JSONObject();
            row.put("id", record.getId());
            row.put("index", record.getIndex());

            List<Score> scores = record.getScores();
            for (Score score : scores) {
                double sc = score.getScore();
                User user = score.getUser();
                row.put(user.getUsername(), sc);
            }
            array.add(row);
        }

        return res;
    }

    @Override
    @Transactional
    public String edit(JSONObject param) {

        String id = param.getString("id");

        List<User> users = cardMapper.getUsers();
        for (User u : users) {
            long editScore = param.getLongValue(u.getUsername());
            Score score = cardMapper.findById(id, u.getId());
            if (score == null) {
                //新增分数记录
            } else {
                //修改分数记录
                score.setScore(editScore);
                cardMapper.updateById(score);
            }
        }


        return "ok";
    }

    @Override
    public int getMaxIndex(long num, long id) {

        return cardMapper.getMaxIndex(num,id);
    }
}
