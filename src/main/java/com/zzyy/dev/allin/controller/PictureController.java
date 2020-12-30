package com.zzyy.dev.allin.controller;


import com.zzyy.dev.allin.entity.PictureDO;
import com.zzyy.dev.allin.servie.PictureService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pic")
public class PictureController {

    private Logger logger = LoggerFactory.getLogger(PictureController.class);

    private static final String PIC_PATH = "/usr/local/tomcat/static/";
    private static final String PIC_PATH_X = "C:\\Users\\Administrator\\Desktop\\pic\\";


    @Resource
    PictureService pictureService;

    @RequestMapping("/upload")
    @ResponseBody
    public String uploadPic(@RequestParam("files") MultipartFile[] files) {


        if (files == null || files.length == 0) {
            return "文件不能为空";
        }

        if (files.length > 9) {
            return "文件最多9张";
        }

        String filePath = PIC_PATH;
        for (MultipartFile file : files) {
            // 上传简单文件名
            String originalFilename = file.getOriginalFilename();
            String type = StringUtils.substringAfterLast(originalFilename, ".");
            String filename = System.currentTimeMillis() + originalFilename;
            // 存储路径
            String allPath = filePath + filename;
            try {
                // 保存文件
                checkDirWxist(PIC_PATH);
                file.transferTo(new File(allPath));
            } catch (IOException e) {
                logger.error("上传图片失败", e);
                e.printStackTrace();
            }
            PictureDO pictureDO = new PictureDO(type, originalFilename, filename, allPath);
            pictureService.uploadPic(pictureDO);

        }
        return "上传完成";
    }

    private void checkDirWxist(String picPath) {

        File file = new File(picPath);
        if (!file.exists()) {
            file.mkdir();
        }

    }

    @RequestMapping("/list")
    @ResponseBody
    public List<PictureDO> list(@RequestParam("pageindex") int pageindex) {

        if (pageindex <= 0) {
            pageindex = 1;
        }
        List<PictureDO> lists = new ArrayList<>(8);
        lists.addAll(pictureService.listPic(pageindex));
        return lists;
    }


}
