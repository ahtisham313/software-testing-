package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        IBookRepository bookRepository = new FakeRepositoryForTest();
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testGetBooksByAuthor() {
        FakeRepositoryForTest.booksList = List.of(
                new Book("1", "Test Driven Development", "Kent Beck")
        );
        List<Book> books = bookService.getBooksByAuthor("Kent Beck", "No books found", FakeRepositoryForTest.booksList);
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthor_NoBooksFound() {
        FakeRepositoryForTest.booksList = List.of();
        List<Book> books = bookService.getBooksByAuthor("Unknown Author", "No books found", FakeRepositoryForTest.booksList);
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorIfNoBookFound() {
        FakeRepositoryForTest.booksList = List.of();
        List<Book> books = bookService.getBooksByAuthorIfNoBookFound("Unknown Author", "No books found", FakeRepositoryForTest.booksList);
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("No books found", books.get(0).getMessage());
    }

    @Test
    public void testGetBooksByAuthorIfTwoBooksFound() {
        FakeRepositoryForTest.booksList = List.of(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Refactoring", "Kent Beck")
        );
        List<Book> books = bookService.getBooksByAuthorIfTwoBooksFound("Kent Beck", "Only one book found", FakeRepositoryForTest.booksList);
        Assertions.assertEquals(2, books.size());
    }

    @Test
    public void testGetBooksByAuthorIfNull() {
        FakeRepositoryForTest.booksList = List.of();
        List<Book> books = bookService.getBooksByAuthorIfNull(null, "No author provided", FakeRepositoryForTest.booksList);
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("No author provided", books.get(0).getMessage());
    }

    @Test
    public void testGetBooksByAuthorWithErrorHandling() {
        FakeRepositoryForTest.booksList = null;
        List<Book> books = bookService.getBooksByAuthorWithErrorHandling("Kent Beck", "Error occurred: ", FakeRepositoryForTest.booksList);
        Assertions.assertEquals(1, books.size());
        Assertions.assertTrue(books.get(0).getMessage().startsWith("Error occurred: "));
    }
}