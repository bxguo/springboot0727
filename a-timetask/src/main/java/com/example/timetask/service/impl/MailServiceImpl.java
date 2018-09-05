package com.example.timetask.service.impl;

import com.example.timetask.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 普通邮件发送
     */
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

    /**
     * 带附件的邮件发送
     */
    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {

        MimeMessage message = sender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);

            FileSystemResource resource = new FileSystemResource(new File(rscPath));
            messageHelper.addInline(rscId, resource);

            sender.send(message);

            logger.info("带静态资源的邮件发送成功");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送html格式邮件
     */
    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage mimeMessage = sender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);

            logger.info("邮件发送成功");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
