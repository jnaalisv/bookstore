package org.jnaalisv.bookstore.infrastructure.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnaalisv.bookstore.model.domain.books.Book;
import org.jnaalisv.bookstore.model.domain.books.BookRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Repository
public class HibernateBookRepository implements BookRepository {

    private final SessionFactory sessionFactory;

    @Inject
    public HibernateBookRepository(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(Book book) {
        getCurrentSession().save(book);
    }

    @Override
    public Optional<Book> get(long bookID) {
        return getCurrentSession()
                .createQuery("select b from Book b where b.id = :bookID", Book.class)
                .setParameter("bookID", bookID)
                .uniqueResultOptional();
    }

    @Override
    public void delete(long bookID) {

    }

    @Override
    public List<Book> getAll() {
        return getCurrentSession()
                .createQuery("select b from Book b", Book.class)
                .list();
    }

    @Override
    public List<Book> findBy(String title) {
         return getCurrentSession()
                .createQuery("SELECT b FROM Book b where b.title like :title", Book.class)
                .setParameter("title", "%"+title + "%")
                .list();

    }
}
