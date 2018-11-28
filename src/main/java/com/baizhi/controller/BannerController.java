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
        Map map = bservice.selectBannerAll(page, rows);
        return map;
    }

    @RequestMapping("/insertBanner")
    public @ResponseBody
    boolean insert(Banner ba) {
        System.out.println(ba + "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        try {
            bservice.insert(ba);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @RequestMapping("/deleteBanner")
    public String delete(Banner ba) {
        bservice.delete(ba.getId());
        return "/main/main";
    }

    @RequestMapping("/updateBanner")
    public String update(Banner ba) {
        bservice.update(ba.getStatus(), ba.getId());
        return "/main/main";
    }
}
