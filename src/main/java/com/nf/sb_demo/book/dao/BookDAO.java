package com.nf.sb_demo.book.dao;


import com.nf.sb_demo.book.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDAO extends CrudRepository<Book, Long> {
    Book getBooksById(Long id);
}
