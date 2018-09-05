package com.example.timetask.service;

/**
 * @author: bxguo
 * @time: 2018/9/4 16:03
 */
public interface MailService {

    void sendSimpleMail(String to, String subject, String content);

    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

    void sendHtmlMail(String to, String subject, String content);
}
