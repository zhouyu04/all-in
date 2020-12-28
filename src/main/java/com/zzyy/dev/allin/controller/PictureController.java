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

@Controller
@RequestMapping("/pic")
public class PictureController {

    private Logger logger = LoggerFactory.getLogger(PictureController.class);

    private static final String PIC_PATH = "/usr/local/webserver/nginx/html/images/";
    private static final String PIC_PATH_X = "C:\\Users\\zzyy\\Desktop\\pic\\";


    @Resource
    PictureService pictureService;

    @RequestMapping("/upload")
    @ResponseBody
    public String uploadPic(@RequestParam("files") MultipartFile[] files) {

        String filePath = PIC_PATH_X;
        for (MultipartFile file : files) {
            // 上传简单文件名
            String originalFilename = file.getOriginalFilename();
            String type = StringUtils.substringAfterLast(originalFilename, ".");
            String filename = System.currentTimeMillis() + originalFilename;
            // 存储路径
            filePath = filePath + filename;
            try {
                // 保存文件
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                logger.error("上传图片失败", e);
                e.printStackTrace();
            }
            PictureDO pictureDO = new PictureDO(type, originalFilename, filename, filePath);
            pictureService.uploadPic(pictureDO);

        }
        System.out.println(filePath);
        return filePath;


//        return "上传成功";
    }


}
