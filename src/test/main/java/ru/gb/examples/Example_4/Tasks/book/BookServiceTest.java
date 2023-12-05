package main.java.ru.gb.examples.Example_4.Tasks.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BookServiceTest {
    BookRepository bookRepositoryMock;
    BookService bookService;
    InMemoryBookRepository inMemoryBookRepository;

    @BeforeEach
    void setUp() {
        bookRepositoryMock = Mockito.spy(InMemoryBookRepository.class);
        bookService = new BookService(bookRepositoryMock);
    }

    @Test
    void testFindIdBookById() {
        Book book = bookService.findBookById("1");
        assertThat(book.getId()).isEqualTo(book.getId());
    }

    @Test
    void testFindTitleBookById() {
        Book book = bookService.findBookById("1");
        assertThat(book.getTitle()).isEqualTo(book.getTitle());
    }

    @Test
    void testFindAuthorBookById() {
        Book book = bookService.findBookById("1");
        assertThat(book.getAuthor()).isEqualTo(book.getAuthor());
    }

    @Test
    void testFindBookById() {
        Book book = new Book("3");
        when(bookRepositoryMock.findById("3")).thenReturn(book);
        assertEquals(book, bookService.findBookById("3"));
    }

    @Test
    void findAllBooks() {
        List<Book> books = bookService.findAllBooks();
        assertThat(books).hasSize(2);
    }

    @Test
    void testFindAllBooks() {
        Book book = new Book("3", "Book3", "Author3");
        when(bookRepositoryMock.findAll()).thenReturn(List.of(book));
        assertEquals(List.of(book), bookService.findAllBooks());
    }
}