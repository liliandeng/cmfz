package com.baizhi;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import com.baizhi.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Test {
    @Autowired
    private static MenuDao menuDao;

    @org.junit.Test
    public static void main(String[] args) {
        MenuService m = new MenuServiceImpl();
        List<Menu> list = menuDao.selectAll();
        for (Menu ss : list) {
            System.out.println(ss);
        }
    }
}
