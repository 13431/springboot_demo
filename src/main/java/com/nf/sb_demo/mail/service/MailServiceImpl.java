package com.nf.sb_demo.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailSender mailSender;

    @Override
    public String sendSimple(String to, String what) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("主题，就是邮件的标题");
        message.setText(what);
        message.setTo(to);

        mailSender.send(message);

        return "success";
    }

    @Override
    public String sendComlex(String to, String what) {
        return null;
    }
}
