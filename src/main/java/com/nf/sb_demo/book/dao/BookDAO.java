package com.nf.sb_demo.book.dao;


import com.nf.sb_demo.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Long> {

}
