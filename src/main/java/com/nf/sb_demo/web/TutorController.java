package com.nf.sb_demo.web;


import com.nf.sb_demo.book.dao.BookDAO;
import com.nf.sb_demo.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/tutor")
public class TutorController {
    @Autowired
    private BookDAO bookDAO;

    @GetMapping("/thymeleaf")
    public String thymeleafTutor(Model model) {
        Iterable<Book> books = bookDAO.findAll();
        model.addAttribute("books", books);
        model.addAttribute("age", 29);
        model.addAttribute("country", "中华人民共和国万岁");
        model.addAttribute("now", new Date());
        return "tutor/thymeleaf";
    }
}
