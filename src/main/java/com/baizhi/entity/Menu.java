package com.baizhi.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private int id;
    private String title;
    private String icon;
    private int pid;
    private String url;

    private List<Menu> me;

    public Menu() {
    }

    public Menu(int id, String title, String icon, int pid, String url) {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.pid = pid;
        this.url = url;
    }
}
