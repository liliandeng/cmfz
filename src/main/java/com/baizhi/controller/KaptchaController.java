package com.baizhi.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


@Controller
public class KaptchaController {
    @Autowired
    private Producer producer;

    @RequestMapping("/getKaptcha")
    public void getKaptcha(HttpSession session, HttpServletResponse response) throws IOException {
        //�����ı�����
        String text = producer.createText();
        //�ı����ݷ���session��������
        session.setAttribute("kaptcha", text);
        //�ı����ݷ���һ�����ɵ�ͼƬ��
        BufferedImage img = producer.createImage(text);

        //ͨ��ͼƬ�����࣬��ͼƬд�뵽��Ӧ�������
        //�м�ΪͼƬ��ʽ��
        ImageIO.write(img, "jpg", response.getOutputStream());
    }
}
