package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Banner {
    private int id;
    private String title;
    private String img;
    private String desc;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date dates;

    public Banner() {
    }

    public Banner(int id, String title, String img, String desc, String status, Date dates) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.desc = desc;
        this.status = status;
        this.dates = dates;
    }
}
