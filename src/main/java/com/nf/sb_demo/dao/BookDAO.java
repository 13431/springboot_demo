package com.nf.sb_demo.dao;

import com.nf.sb_demo.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookDAO extends CrudRepository<Book, Long> {
    List<Book> getBooksByName(String name);
}
