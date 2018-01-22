package com.nf.sb_demo.book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 2, max = 9)
    //@Xuehao
    private String name;

    @NotNull(message = "怎么，你想免费给别人发书？太高尚了，赞")
    @Min(value = 10, message = "要想多赚钱，心要狠，价要高")
    private Float price;

    @ManyToOne
    private Author author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
