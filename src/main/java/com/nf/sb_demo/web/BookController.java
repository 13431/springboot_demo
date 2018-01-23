package com.nf.sb_demo.web;

import com.nf.sb_demo.book.dao.AuthorDAO;
import com.nf.sb_demo.book.dao.BookDAO;
import com.nf.sb_demo.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

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
    public String save(@Valid Book book, Errors errors, RedirectAttributesModelMap flash, Model model) {
        if (invalidBook(book, errors, model)) {
            return "book/add";
        }

        bookDAO.save(book);

        flash.addFlashAttribute("msg", "保存成功!");
        flash.addFlashAttribute("msgType", "success");

        return "redirect:index";
    }


    @GetMapping("/delete")
    public String deleteBook(Long id) {
        bookDAO.delete(id);
        return "redirect:index";
    }

    @GetMapping("/update")
    public String toEdie(Model model, Long id) {
        model.addAttribute("book", bookDAO.getOne(id));
        model.addAttribute("authors", authorDAO.findAll());
        return "book/update";
    }

    @PostMapping("/update")
    public String edit(@Valid Book book, BindingResult result, Model model, RedirectAttributesModelMap flash) {
        if (invalidBook(book, result, model)) {
            return "book/update";
        }

        bookDAO.save(book);

        flash.addFlashAttribute("msg", "保存成功!");
        return "redirect:index";
    }

    private boolean invalidBook(Book book, Errors result, Model model) {
        if (book.getAuthor() == null || book.getAuthor().getId() < 1) {
            result.rejectValue("author", null, "您需要填写作者的信息哦!");
        }
        if (result.hasErrors()) {
            model.addAttribute("authors", authorDAO.findAll());
        }
        return result.hasErrors();
    }

}
