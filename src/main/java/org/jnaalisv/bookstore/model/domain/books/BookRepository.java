package org.jnaalisv.bookstore.model.domain.books;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void add(Book book);

    Optional<Book> get(long bookID);

    void delete(long bookID);

    List<Book> getAll();

    List<Book> findBy(String title);

    void update(Book aBook);

}
