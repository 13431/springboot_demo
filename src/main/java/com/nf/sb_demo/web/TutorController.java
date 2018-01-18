package com.nf.sb_demo.web;


import com.nf.sb_demo.dao.BookDAO;
import com.nf.sb_demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tutor")
public class TutorController {
    @Autowired
    private BookDAO bookDAO;

    @GetMapping("/thymeleaf")
    public String thymeleafTutor (Model model) {
        Iterable<Book> books = bookDAO.findAll();
        model.addAttribute("books", books);
        return "tutor/thymeleaf";
    }
}
