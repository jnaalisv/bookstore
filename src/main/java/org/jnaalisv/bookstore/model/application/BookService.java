package org.jnaalisv.bookstore.model.application;

import org.jnaalisv.bookstore.model.domain.books.Book;
import org.jnaalisv.bookstore.model.domain.books.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Inject
    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void saveNew(Book book) {
        this.bookRepository.add(book);
    }

    @Transactional
    public Book loadBy(long id) {
        return bookRepository
                .get(id)
                .orElseThrow(() -> NotFoundException.byId(Book.class, id));
    }

    @Transactional
    public List<Book> loadAll() {
        return bookRepository.getAll();
    }
}
