import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryManagementSystemTest {

    LibraryManagementSystem lib = new LibraryManagementSystem();

    @Test
    public void testSuccessfulAddition() {
        assertTrue(lib.addBook("978-3-16-148410-0", "Effective Java", "Joshua Bloch", 2018, 5));
    }

    @Test
    public void testInvalidISBNFormat() {
        assertFalse(lib.addBook("123", "Effective Java", "Joshua Bloch", 2018, 5));
    }

    @Test
    public void testEmptyTitle() {
        assertFalse(lib.addBook("978-3-16-148410-0", "", "Joshua Bloch", 2018, 5));
    }

    @Test
    public void testYearBelowMinimum() {
        assertFalse(lib.addBook("978-3-16-148410-0", "Effective Java", "Joshua Bloch", 1499, 5));
    }

    @Test
    public void testZeroCopies() {
        assertFalse(lib.addBook("978-3-16-148410-0", "Effective Java", "Joshua Bloch", 2018, 0));
    }
}