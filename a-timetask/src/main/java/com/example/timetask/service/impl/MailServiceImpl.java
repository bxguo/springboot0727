package com.example.timetask.service.impl;

import com.example.timetask.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author: bxguo
 * @time: 2018/9/4 16:03
 */
@Service
public class MailServiceImpl implements MailService {


    @Value("${mail.fromMail.addr}")
    private String from;

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            sender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}
