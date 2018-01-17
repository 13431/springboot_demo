package com.nf.sb_demo.web;


import com.nf.sb_demo.dao.BookDAO;
import com.nf.sb_demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    BookDAO bookDAO = null;

    @GetMapping("/index")
    public String listAll(Model model) {
        model.addAttribute("books", bookDAO.findAll());
        return "book_list";
    }

    @GetMapping("/book/add")
    public String addBook() {
        return "book_add";
    }

    @PostMapping("/book/store")
    public String addBook(Book book) {
        bookDAO.save(book);
        return "redirect:/index";
    }

    @PostMapping("/book/delete")
    public String deleBook(Long id) {
        bookDAO.delete(id);
        return "redirect:/index";
    }

}
