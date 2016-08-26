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
        return null;
    }

    @Override
    public List<Book> findBy(String title) {
        return null;
    }

//    @Override
//    public void add(Customer customer) {
//        getCurrentSession().save(customer);
//    }
//
//    @Override
//    public Optional<Customer> get(long id) {
//        return getCurrentSession()
//                .createQuery("select c from Customer c where c.id = :id", Customer.class)
//                .setParameter("id", id)
//                .uniqueResultOptional();
//    }
//
//    @Override
//    public List<Customer> getAll() {
//        return getCurrentSession()
//                .createQuery("select c from Customer c", Customer.class)
//                .list();
//    }
//
//    @Override
//    public List<Customer> findByName(String name) {
//        return getCurrentSession()
//                .createQuery("SELECT c FROM Customer c where c.name like :name", Customer.class)
//                .setParameter("name", "%"+name + "%")
//                .list();
//    }
}
