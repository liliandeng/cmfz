package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Album implements Serializable {
    private int id;
    private String title;
    private String coverlmg;
    private int count;
    private String score;
    private String author;
    private String broadcast;
    private String brief;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date publishdate;
    private List<Chapter> children;

    public Album() {
    }

    public Album(int id, String title, String coverlmg, int count, String score, String author, String broadcast, String brief, Date publishdate, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.coverlmg = coverlmg;
        this.count = count;
        this.score = score;
        this.author = author;
        this.broadcast = broadcast;
        this.brief = brief;
        this.publishdate = publishdate;
        this.children = children;
    }

    public Album(int id, String title, String coverlmg, int count, String score, String author, String broadcast, String brief, Date publishdate) {
        this.id = id;
        this.title = title;
        this.coverlmg = coverlmg;
        this.count = count;
        this.score = score;
        this.author = author;
        this.broadcast = broadcast;
        this.brief = brief;
        this.publishdate = publishdate;
    }

    public Album(String title, String coverlmg, int count, String score, String author, String broadcast, String brief, Date publishdate) {
        this.title = title;
        this.coverlmg = coverlmg;
        this.count = count;
        this.score = score;
        this.author = author;
        this.broadcast = broadcast;
        this.brief = brief;
        this.publishdate = publishdate;
    }
}