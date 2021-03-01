package com.zzyy.dev.allin.mapper;

import com.zzyy.dev.allin.entity.CardRecord;
import com.zzyy.dev.allin.entity.House;
import com.zzyy.dev.allin.entity.Score;
import com.zzyy.dev.allin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: zhouyu
 * @Date: 2021/2/23 18:06
 * @Description:
 */
@Mapper
public interface CardMapper {

    House getHouse();

    int checkIsActive(long num);

    void joinHouse(@Param("num") long num, @Param("userId") long userId);

    int checkExist();

    int createHouse(House house);

    List<User> getHouseUser(long num);


    List<CardRecord> getRecord(long num);

    List<User> getUsers();

    Score findById(@Param("indexId") String indexId, @Param("userId") long userId);

    void updateById(Score score);

    int getMaxIndex(@Param("num") long num, @Param("userId") long userId);
}
