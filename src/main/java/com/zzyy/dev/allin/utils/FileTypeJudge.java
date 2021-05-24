package com.zzyy.dev.allin.utils;

import com.zzyy.dev.allin.entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileTypeJudge {


    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setUsername("周" + i);
            users.add(user);
        }

        Map<Long, User> collect = users.stream().collect(Collectors.toMap(User::getId, v -> v, (v1, v2) -> v1));
        System.out.println(collect);


    }

    /**
     * Constructor
     */
    private FileTypeJudge() {
    }

    /**
     * 将文件头转换成16进制字符串
     *
     * @param src
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] src) {

        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }


    /**
     * 得到文件头
     *
     * @param is 文件路径
     * @return 文件头
     * @throws IOException
     */
    private static String getFileContent(InputStream is) throws IOException {

        byte[] b = new byte[28];

        InputStream inputStream = null;

        try {
            is.read(b, 0, 28);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        }
        return bytesToHexString(b);
    }

    /**
     * 判断文件类型
     *
     * @param is 文件路径
     * @return 文件类型
     */
    public static FileType getType(InputStream is) throws IOException {

        String fileHead = getFileContent(is);
        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }
        fileHead = fileHead.toUpperCase();
        FileType[] fileTypes = FileType.values();

        for (FileType type : fileTypes) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }

        return null;
    }

    /**
     * @param value 表示文件类型
     * @return
     */
    public static Integer isFileType(FileType value) {
        Integer type = 7;// 其他
        // 图片
        FileType[] pics = {FileType.JPEG, FileType.PNG, FileType.GIF, FileType.TIFF, FileType.BMP, FileType.DWG, FileType.PSD};

        FileType[] docs = {FileType.RTF, FileType.XML, FileType.HTML, FileType.CSS, FileType.JS, FileType.EML, FileType.DBX, FileType.PST, FileType.XLS_DOC, FileType.XLSX_DOCX, FileType.VSD,
                FileType.MDB, FileType.WPS, FileType.WPD, FileType.EPS, FileType.PDF, FileType.QDF, FileType.PWL, FileType.ZIP, FileType.RAR, FileType.JSP, FileType.JAVA, FileType.CLASS,
                FileType.JAR, FileType.MF, FileType.EXE, FileType.CHM};

        FileType[] videos = {FileType.AVI, FileType.RAM, FileType.RM, FileType.MPG, FileType.MOV, FileType.ASF, FileType.MP4, FileType.FLV, FileType.MID};

        FileType[] tottents = {FileType.TORRENT};

        FileType[] audios = {FileType.WAV, FileType.MP3};

        FileType[] others = {};

        // 图片
        for (FileType fileType : pics) {
            if (fileType.equals(value)) {
                type = 1;
            }
        }
        // 文档
        for (FileType fileType : docs) {
            if (fileType.equals(value)) {
                type = 2;
            }
        }
        // 视频
        for (FileType fileType : videos) {
            if (fileType.equals(value)) {
                type = 3;
            }
        }
        // 种子
        for (FileType fileType : tottents) {
            if (fileType.equals(value)) {
                type = 4;
            }
        }
        // 音乐
        for (FileType fileType : audios) {
            if (fileType.equals(value)) {
                type = 5;
            }
        }
        return type;
    }

}
