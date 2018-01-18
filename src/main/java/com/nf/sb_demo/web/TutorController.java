package com.nf.sb_demo.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tutor")
public class TutorController {

    @GetMapping("/thymeleaf")
    public String thymeleafTutor (Model model) {
        model.addAttribute("content", "hello");
        model.addAttribute("class", "green blue yigedaerror");
        return "tutor/thymeleaf";
    }
}
