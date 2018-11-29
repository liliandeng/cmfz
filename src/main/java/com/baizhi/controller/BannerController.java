package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
    boolean insert(Banner ba, MultipartFile wenjian, HttpServletRequest request) {
       /* // 获取上传的文件的名字
        String fileName = uploadFile.getOriginalFilename();
        // 通过uuid获取新名字
        String newFileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
        //1.获取文件夹的相对路径
        String realPath = req.getSession().getServletContext().getRealPath("/img");
        //2.file对象（上传到项目的productImages文件夹中）
        File file = new File(realPath+"\\"+newFileName);
        //3.写入
        uploadFile.transferTo(file);
       ba.setImg(newFileName);
      // ba.setDates(new Date());
        //ba.setStatus("展示");*/

        try {
            // 获取文件的名字
            String fileName = wenjian.getOriginalFilename();
            // System.out.println("文件上传的名字" + fileName);
            // 文件重新命名
            // fileName = new Date().getTime() + "_" + fileName;
            // 把接收到的文件转换成磁盘文件
            // wenjian.transferTo(new
            // File("F:\\Tomcat\\apache-tomcat-7.0.72\\webapps\\SpringmvcAuction\\wenjian"+fileName));
            // 根据文件夹名字获取绝对路径
            String realPath = request.getRealPath("img");
            wenjian.transferTo(new File(realPath + "\\" + fileName));
            ba.setImg(fileName);
            bservice.insert(ba);
            System.out.println(ba);
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
