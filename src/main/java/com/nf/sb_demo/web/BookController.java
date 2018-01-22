package com.nf.sb_demo.web;

import com.nf.sb_demo.book.dao.AuthorDAO;
import com.nf.sb_demo.book.dao.BookDAO;
import com.nf.sb_demo.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private AuthorDAO authorDAO;

    @GetMapping("/index")
    public String list(Model model) {
        model.addAttribute("books", bookDAO.findAll());
        return "book/index";
    }

    @GetMapping("/add")
    public String add(Book book, Model model) {
        model.addAttribute("authors", authorDAO.findAll());
        return "book/add";
    }

    @PostMapping("/add")
    public String save(@Valid Book book, Errors errors, Model model) {
        if (book.getAuthor() == null || book.getAuthor().getId() < 1) {
            errors.rejectValue("author", null, "您需要填写作者的信息哦!");
        }
        if (errors.hasErrors()) {
            model.addAttribute("authors", authorDAO.findAll());
            return "book/add";
        }
        bookDAO.save(book);
        return "redirect:index";
    }


}
