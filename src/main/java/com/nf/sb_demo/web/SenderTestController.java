package com.nf.sb_demo.web;

import com.nf.sb_demo.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SenderTestController {

    @Autowired
    private Sender sender;

    public String test () {
        sender.send("xxx@qq.com", "你吃了吗");
        return null;
    }
}
