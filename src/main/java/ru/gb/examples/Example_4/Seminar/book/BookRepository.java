package main.java.ru.gb.examples.Example_4.Seminar.book;

import java.util.List;

public interface BookRepository {
    Book findById(String id);
    List<Book> findAll();
}
