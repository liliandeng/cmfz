package com.baizhi.dao;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuDao {

    //查询分类
    public List<Menu> selectAll();

}
