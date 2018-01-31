package com.nf.sb_demo.service.mail;

import com.nf.sb_demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailServiceImpl implements MailService {

    @Autowired
    private MailSender mailSender;

    @Override
    public String send(String to, String what, String type) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("主题，就是邮件的标题");
        message.setText(what);
        message.setTo(to);

        mailSender.send(message);

        return "success";
    }

    @Override
    public String send(String to, String what) {
        return null;
    }
}
