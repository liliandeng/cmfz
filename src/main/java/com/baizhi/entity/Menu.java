package com.baizhi.entity;

import lombok.Data;

@Data
public class Menu {
    private int id;
    private String title;
    private String icon;
    private int pid;
    private String url;
}
