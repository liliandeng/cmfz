package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    private AdminService aservice;

    @RequestMapping("/selectAdminOne")
    //session 获取验证码，yzm 获取jsp页面传递的验证码
    public String selectOne(Admin ad, HttpSession session, String yzm) {
        String ss = (String) session.getAttribute("kaptcha");
        if (yzm.equals(ss) && ad != null) {
            ad = aservice.selectOne(ad);
            session.setAttribute("admin", ad);
            System.out.println(ad);
            return "redirect:/main/main.jsp";
        } else {
            return "redirect:/login.jsp";
        }
    }

    //登出
    @RequestMapping("/remove")
    public String remove(HttpSession session) {
        session.removeAttribute("admin");
        return "redirect:/login.jsp";
    }

}
