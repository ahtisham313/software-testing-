package com.example.tdd;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksByAuthor(String author, String message, List<Book> books) {
        if (author == null) {
            return Collections.emptyList();
        }
        return bookRepository.findAllBooks().stream()
                .filter(book -> author.equals(book.getAuthor()))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByAuthorIfNoBookFound(String author, String message, List<Book> books) {
        List<Book> booksFound = getBooksByAuthor(author, "No books found", books);
        if (booksFound.isEmpty()) {
            return List.of(new Book(author,"No books found",message));
        }
        return booksFound;
    }

    public List<Book> getBooksByAuthorIfTwoBooksFound(String author, String message, List<Book> books) {
        List<Book> booksFound = getBooksByAuthor(author, "Only one book found", books);
        if (booksFound.size() == 2) {
            return booksFound;
        }
        return List.of(new Book(author,"Only one book found", message));
    }

    public List<Book> getBooksByAuthorIfNull(String author, String message, List<Book> books) {
        if (author == null) {
            return List.of(new Book(author,"No author provided",message));
        }
        return getBooksByAuthor(author, "No author provided", books);
    }

    public List<Book> getBooksByAuthorWithErrorHandling(String author, String message, List<Book> books) {
        try {
            return getBooksByAuthor(author, "Error occurred: ", books);
        } catch (Exception e) {
            return List.of(new Book(author,"Error occurred: " + e.getMessage(),message));
        }
    }
}