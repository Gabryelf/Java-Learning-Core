package seminars.four.hw;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import seminars.four.hw.repository.BookRepository;
import seminars.four.hw.service.BookService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static javax.management.Query.times;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    public BookServiceTest(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindBookById() {
        Long bookId = 1L;
        Book expectedBook = new Book();
        expectedBook.setId(bookId);
        expectedBook.setTitle("Mock Book");
        expectedBook.setAuthor("Mock Author");

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(expectedBook));

        Optional<Book> result = bookService.findBookById(bookId);

        assertEquals(expectedBook, result.orElse(null));
        verify(bookRepository, times(1)).findById(bookId);
    }

    @Test
    void testFindAllBooks() {
        List<Book> expectedBooks = Arrays.asList(
                new Book(1L, "Book 1", "Author 1"),
                new Book(2L, "Book 2", "Author 2")
        );

        when(bookRepository.findAll()).thenReturn(expectedBooks);

        List<Book> result = bookService.findAllBooks();

        assertEquals(expectedBooks, result);
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void testAddBook() {
        Book newBook = new Book();
        newBook.setTitle("New Book");
        newBook.setAuthor("New Author");

        bookService.addBook(newBook);

        verify(bookRepository, times(1)).save(newBook);
    }

    @Test
    void testDeleteBookById() {
        Long bookId = 1L;

        bookService.deleteBookById(bookId);

        verify(bookRepository, times(1)).deleteById(bookId);
    }
}
