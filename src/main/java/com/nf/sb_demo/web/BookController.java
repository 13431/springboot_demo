package com.nf.sb_demo.web;


import com.nf.sb_demo.dao.BookDAO;
import com.nf.sb_demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookDAO bookDAO;

    @GetMapping("/list")
    public String listAll(Model model) {
        model.addAttribute("books", bookDAO.findAll());
        return "book_list";
    }

    @GetMapping("/add")
    public String addBook() {
        return "book_add";
    }

    @PostMapping("/store")
    public String addBook(Book book) {
        bookDAO.save(book);
        return "redirect:list";
    }

    @PostMapping("/del")
    public String deleteBook(Long id) {
        bookDAO.delete(id);
        return "redirect:list";
    }

}
