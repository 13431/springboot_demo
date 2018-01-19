package com.nf.sb_demo.web;

import com.nf.sb_demo.book.dao.AuthorDAO;
import com.nf.sb_demo.book.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
    @Autowired
    private AuthorDAO authorDAO;

    @GetMapping("/author_add")
    public String add() {
        return "book/add_author";
    }

    @PostMapping("/author_add")
    public String store(Author author) {
        authorDAO.save(author);
        return "redirect:author_add";
    }
}
