package com.zzyy.dev.allin.servie;

import com.zzyy.dev.allin.entity.PictureDO;

import java.util.List;

public interface PictureService {
    void uploadPic(PictureDO pictureDO);

    List<PictureDO> listPic(int pageindex);
}
