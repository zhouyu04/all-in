package com.zzyy.dev.allin.mapper;

import com.zzyy.dev.allin.entity.Kvs;
import com.zzyy.dev.allin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IndexMapper {

    Kvs getCodeByKey(@Param("key") String code);

    User getUserByname(String username);
}
