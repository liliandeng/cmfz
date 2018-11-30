package com.baizhi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Chapter implements Serializable {
    private String id;
    private String title;
    private int aid;
    private String size;
    private String duration;
    private String downpath;
    private Date uploaddate;

    public Chapter() {
    }

    public Chapter(String id, String title, int aid, String size, String duration, String downpath, Date uploaddate) {
        this.id = id;
        this.title = title;
        this.aid = aid;
        this.size = size;
        this.duration = duration;
        this.downpath = downpath;
        this.uploaddate = uploaddate;
    }

    public Chapter(String id, String title, int aid, String size, String duration, String downpath) {
        this.id = id;
        this.title = title;
        this.aid = aid;
        this.size = size;
        this.duration = duration;
        this.downpath = downpath;
    }
}