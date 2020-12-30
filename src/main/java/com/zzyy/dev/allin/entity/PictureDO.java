package com.zzyy.dev.allin.entity;

import java.util.Date;

public class PictureDO {

    private long id;

    private String type;

    private String originname;

    private String filename;

    private String filepath;

    private Date createtime;

    public PictureDO() {
    }

    public PictureDO(String type, String originname, String filename, String filepath) {
        this.type = type;
        this.originname = originname;
        this.filename = filename;
        this.filepath = filepath;
    }

    public PictureDO(long id, String type, String originname, String filename, String filepath, Date createtime) {
        this.id = id;
        this.type = type;
        this.originname = originname;
        this.filename = filename;
        this.filepath = filepath;
        this.createtime = createtime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOriginname() {
        return originname;
    }

    public void setOriginname(String originname) {
        this.originname = originname;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
