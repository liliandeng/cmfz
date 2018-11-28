package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class BannerController {

    @Autowired
    private BannerService bservice;

    @RequestMapping("/selectBannerAll")
    public @ResponseBody
    Map select(int page, int rows) {
        System.out.println(page + "+++++++++++++++++" + rows);
        System.out.println("ssssssssssssssssssssssssssssssssssss");
        Map map = bservice.selectBannerAll(page, rows);
        return map;
    }

    @RequestMapping("/insertBanner")
    public String insert(Banner ba) {
        System.out.println(ba + "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        bservice.insert(ba);
        System.out.println(ba + "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        return "/main/main";
    }

    @RequestMapping("/deleteBanner")
    public String delete(Banner ba) {
        System.out.println(ba + "dddddddddddddddddddddddddddddddddddd");
        bservice.delete(ba.getId());
        System.out.println(ba + "dddddddddddddddddddddddddddddddddddd");
        return "/main/main";
    }

    @RequestMapping("/updateBanner")
    public String update(Banner ba) {
        System.out.println(ba + "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        bservice.update(ba.getStatus(), ba.getId());
        System.out.println(ba + "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        return "/main/main";
    }
}
