package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

@Controller
public class ChapterController {
    @Autowired
    private ChapterService cservice;

    @RequestMapping("/addChapter")
    public @ResponseBody
    boolean add(String titles, MultipartFile wenjian, Chapter ch, Integer id, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/");  //webapp当前项目的路径
        File file = new File(realPath + "/upload");
        if (!file.exists()) {
            file.mkdir();
        }

        //测试音乐.MP3   11111111.MP3
        //获取文件的名字
        String extension = FilenameUtils.getExtension(wenjian.getOriginalFilename());
        //System.out.println("老名字" + extension);
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        //拼接   新得名字
        String newName = s + "." + extension;

        System.out.println("新名字" + newName);
        try {
            wenjian.transferTo(new File(file.getAbsolutePath(), newName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //时长
        int length = FileUtil.getDuration(new File(file.getAbsolutePath() + "/" + newName));
        long size = wenjian.getSize();
        double l = size / 1024.0 / 1024.0;
        String daxiao = l + "MB";
        System.out.println(titles + "++++++++++++++++++++++");
        ch.setTitle(titles);
        ch.setId(s);
        //文件的大小
        ch.setSize(daxiao);
        //外键
        ch.setAid(id);
        //地址
        ch.setDownpath(newName);
        //时长
        int fen = length / 60;
        int miao = length % 60;
        String shichang = fen + "分" + miao + "秒";
        ch.setDuration(shichang);
        //文件大小  时长  名字  url   date
        try {
            cservice.addChapter(ch);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/download")
    public void download(String downpath, String title, HttpServletRequest request, HttpServletResponse response) {
        String uploadPath = request.getSession().getServletContext().getRealPath("upload");  //webapp当前项目的路径
        String path = uploadPath + "/" + downpath;
        File file = new File(path);

        String s = title + "." + "mp3";


        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(s, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("audio/mpeg");

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
