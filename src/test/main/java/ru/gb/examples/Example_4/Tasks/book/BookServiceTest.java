package main.java.ru.gb.examples.Example_4.Tasks.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    BookRepository bookRepositoryMock;
    BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);
    }

    @Test
    void testFindBookById() {
        Book book = new Book("3", "Book3", "Author3");
        when(bookRepositoryMock.findById("3")).thenReturn(book);
        assertEquals(book, bookService.findBookById("3"));
    }

    @Test
    void testFindAllBooks() {
        Book book = new Book("3", "Book3", "Author3");
        when(bookRepositoryMock.findAll()).thenReturn(List.of(book));
        assertEquals(List.of(book), bookService.findAllBooks());
    }
}