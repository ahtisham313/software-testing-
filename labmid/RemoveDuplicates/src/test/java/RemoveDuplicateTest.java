import com.mycompany.removeduplicates.RemoveDuplicates;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicateTest {

//    @Test
    public void testEmptyArray() {
        int[] array = {};
        int newLength = RemoveDuplicates.removeDuplicates(array);
        assertEquals(0, newLength);
        assertArrayEquals(new int[]{}, Arrays.copyOf(array, newLength));
    }

//    @Test
    public void testNoDuplicates() {
        int[] array = {1, 2, 3, 4, 5};
        int newLength = RemoveDuplicates.removeDuplicates(array);
        assertEquals(5, newLength);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Arrays.copyOf(array, newLength));
    }

//    @Test
    public void testAllDuplicates() {
        int[] array = {1, 1, 1, 1};
        int newLength = RemoveDuplicates.removeDuplicates(array);
        assertEquals(1, newLength);
        assertArrayEquals(new int[]{1}, Arrays.copyOf(array, newLength));
    }

//    @Test
    public void testSomeDuplicates() {
        int[] array = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = RemoveDuplicates.removeDuplicates(array);
        assertEquals(5, newLength);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Arrays.copyOf(array, newLength));
    }

//    @Test
    public void testTrailingDuplicates() {
        int[] array = {1, 2, 3, 4, 5, 5, 5, 5};
        int newLength = RemoveDuplicates.removeDuplicates(array);
        assertEquals(5, newLength);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Arrays.copyOf(array, newLength));
    }
}

