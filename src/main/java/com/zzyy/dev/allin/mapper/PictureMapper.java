package com.zzyy.dev.allin.mapper;

import com.zzyy.dev.allin.entity.PictureDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PictureMapper {
    void addPicture(PictureDO pictureDO);

    List<PictureDO> listPic(@Param("pageindex") int pageindex,@Param("pagesize") int pagesize);
}
