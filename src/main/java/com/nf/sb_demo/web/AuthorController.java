package com.nf.sb_demo.web;

import com.nf.sb_demo.book.dao.AuthorDAO;
import com.nf.sb_demo.book.entity.Author;
import com.nf.sb_demo.book.validator.AuthorValidatorOfSpringWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorDAO authorDAO;

    @InitBinder // 是在所有方法之前去执行的一个方法，可以做很多初始化方面的工作
    public void init(DataBinder binder) {
        binder.addValidators(new AuthorValidatorOfSpringWay());
    }

    @GetMapping("/add")
    public String add(Author author) {
        return "author/add";
    }

    @PostMapping("/add")
    public String store(@Valid Author author, BindingResult result) {
        if(result.hasErrors()) {
            return "author/add";
        }
        authorDAO.save(author);
        return "redirect:/author/add";
    }
}
