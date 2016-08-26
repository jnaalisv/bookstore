package org.jnaalisv.bookstore.web.interfaces.books;

import org.jnaalisv.bookstore.model.application.BookService;
import org.jnaalisv.bookstore.model.domain.books.Book;
import org.jnaalisv.bookstore.web.interfaces.BookstoreWebResources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(BookstoreWebResources.BOOKS)
public class BooksController {

    private BookService bookService;

    @Inject
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BookDTO> post(@RequestBody BookDTO bookDTO) {

        Book aNewBook = new Book(bookDTO.title, bookDTO.author, bookDTO.description, bookDTO.price, bookDTO.published);

        bookService.saveNew(aNewBook);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location", "books/"+aNewBook.getId());
        return new ResponseEntity<>(new BookDTO(aNewBook), responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("{bookID}")
    public BookDTO get(@PathVariable long bookID) {
        return new BookDTO(bookService.loadBy(bookID));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<BookDTO> getAll() {
        return bookService
                .loadAll()
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("{bookID}")
    public void delete(long bookID) {
        bookService.delete(bookID);
    }

}
