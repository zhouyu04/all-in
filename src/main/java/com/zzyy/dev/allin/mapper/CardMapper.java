package com.zzyy.dev.allin.mapper;

import com.zzyy.dev.allin.entity.House;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: zhouyu
 * @Date: 2021/2/23 18:06
 * @Description:
 */
@Mapper
public interface CardMapper {

    House getHouse();
}
