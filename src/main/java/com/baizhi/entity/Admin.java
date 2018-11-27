package com.baizhi.entity;

import lombok.Data;

@Data
public class Admin {
    private int id;
    private String name;
    private String pass;

    public Admin() {
    }

    public Admin(int id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

}
