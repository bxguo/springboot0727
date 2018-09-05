package com.example.timetask;

import com.example.timetask.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimetaskApplicationTests {

    @Autowired
    private MailService mailService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendMailTest() {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";

        mailService.sendHtmlMail("bxguo@hotmail.com","测试", content);
    }
    @Test
    public void sendImgMailTest() {

        String to = "bxguo@hotmail.com";
        String rscId = "neo006";
        String subject = "带图片的邮件";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\summer\\Pictures\\favicon.png";


        mailService.sendInlineResourceMail(to, subject, content, imgPath, rscId);
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        TemplateEngine templateEngine = new TemplateEngine();

        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("ityouknow@126.com","主题：这是模板邮件",emailContent);
    }


}
