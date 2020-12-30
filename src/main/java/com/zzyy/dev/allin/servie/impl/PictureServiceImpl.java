package com.zzyy.dev.allin.servie.impl;

import com.zzyy.dev.allin.entity.PictureDO;
import com.zzyy.dev.allin.mapper.PictureMapper;
import com.zzyy.dev.allin.servie.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private static final int PAGE_SIZE = 8;

    @Resource
    PictureMapper pictureMapper;

    @Override
    public void uploadPic(PictureDO pictureDO) {

        pictureMapper.addPicture(pictureDO);
    }

    @Override
    public List<PictureDO> listPic(int pageindex) {

        pageindex = (pageindex - 1) * PAGE_SIZE;

        return pictureMapper.listPic(pageindex,PAGE_SIZE);
    }
}
