package com.example.timetask;

import com.example.timetask.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}
