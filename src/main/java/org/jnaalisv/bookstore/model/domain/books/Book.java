package org.jnaalisv.bookstore.model.domain.books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    private String title;
    private String author;
    private String description;
    private BigDecimal price;
    private LocalDate published;

    public Book() {}

    public Book(String title, String author, String description, BigDecimal price, LocalDate published) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this. published = published;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getPublished() {
        return published;
    }
}
