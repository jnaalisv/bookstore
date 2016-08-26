package org.jnaalisv.bookstore.web.interfaces.books;

import org.jnaalisv.bookstore.model.domain.books.Book;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookDTO {

    public long id;
    public String title;
    public String author;
    public String description;
    public BigDecimal price;
    public LocalDate published;

    public BookDTO() {}

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.description = book.getDescription();
        this.price = book.getPrice();
        this.published = book.getPublished();
    }
}
