package com.nf.sb_demo.web;

import com.nf.sb_demo.book.dao.BookDAO;
import com.nf.sb_demo.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BookDAO bookDAO;

    @RequestMapping("/")
    public String index() {
        return "redirect:/book/index";
    }

    @RequestMapping("/vue")
    public String vue() {
        return "vue/index";
    }

    @RequestMapping("/vuex")
    @ResponseBody
    public List<Book> vue2() {
        return bookDAO.findAll();
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public String del(@PathVariable Long id ) {
        bookDAO.delete(id);
        return null;
    }
    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestBody Book book ) {
        bookDAO.save(book);
        return null;
    }



}
