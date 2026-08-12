package seminars.four.hw.repository;

import seminars.four.hw.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(Long id);
    List<Book> findAll();
    void save(Book book);
    void deleteById(Long id);
}

