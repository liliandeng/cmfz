package com.baizhi.controller;

import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class AlbumController {
    @Autowired
    private AlbumService alservice;

    @RequestMapping("/selectAlbumAll")
    public @ResponseBody
    Map select(int page, int rows) {
        System.out.println(page + "============" + rows);
        Map map = alservice.selectAlbumAll(page, rows);
        System.out.println(map);
        return map;
    }

}
