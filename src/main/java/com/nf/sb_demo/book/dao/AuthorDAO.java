package com.nf.sb_demo.book.dao;

import com.nf.sb_demo.book.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDAO extends JpaRepository<Author, Long> {
}
