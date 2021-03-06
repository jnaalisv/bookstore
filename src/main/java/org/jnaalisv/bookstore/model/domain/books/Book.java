package org.jnaalisv.bookstore.model.domain.books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "books")
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
    private LocalDateTime deleted;

    public Book() {}

    public Book(long id, String title, String author, String description, BigDecimal price, LocalDate published) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this. published = published;
    }

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

    public void delete(LocalDateTime deleteTime) {
        this.deleted = deleteTime;
    }
}
