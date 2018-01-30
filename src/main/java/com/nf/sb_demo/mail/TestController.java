package com.nf.sb_demo.mail;

import com.nf.sb_demo.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    @Autowired
    private MailService mailService;

    public String test () {
        mailService.sendSimple("xxx@qq.com", "你吃了吗");
        return null;
    }
}
