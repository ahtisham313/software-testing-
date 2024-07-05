import java.util.HashMap;
import java.util.Map;

public class LibraryManagementSystem {
    private final Map<String, Book> collection;

    public LibraryManagementSystem() {
        collection = new HashMap<>();
    }

    public boolean addBook(String ISBN, String title, String author, int year, int copies) {
        if (!isValidISBN(ISBN) || title == null || title.isEmpty() || author == null || author.isEmpty() || year < 1500 || year > 2024 || copies <= 0) {
            return false;
        }

        if (collection.containsKey(ISBN)) {
            Book existingBook = collection.get(ISBN);
            existingBook.setCopies(existingBook.getCopies() + copies);
        } else {
            Book newBook = new Book(ISBN, title, author, year, copies);
            collection.put(ISBN, newBook);
        }

        return true;
    }

    private boolean isValidISBN(String ISBN) {
        return ISBN != null && (ISBN.length() == 10 || ISBN.length() == 13) && ISBN.matches("\\d+(-\\d+)*");
    }

    public Book getBook(String ISBN) {
        return collection.get(ISBN);
    }
}
