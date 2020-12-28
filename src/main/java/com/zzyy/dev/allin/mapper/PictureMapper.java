package com.zzyy.dev.allin.mapper;

import com.zzyy.dev.allin.entity.PictureDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PictureMapper {
    void addPicture(PictureDO pictureDO);
}
