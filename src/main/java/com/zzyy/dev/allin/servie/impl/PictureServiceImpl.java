package com.zzyy.dev.allin.servie.impl;

import com.zzyy.dev.allin.entity.PictureDO;
import com.zzyy.dev.allin.mapper.PictureMapper;
import com.zzyy.dev.allin.servie.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PictureServiceImpl implements PictureService {

    @Resource
    PictureMapper pictureMapper;

    @Override
    public void uploadPic(PictureDO pictureDO) {

        pictureMapper.addPicture(pictureDO);
    }
}
