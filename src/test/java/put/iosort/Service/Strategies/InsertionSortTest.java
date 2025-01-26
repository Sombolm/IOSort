package put.iosort.Service.Strategies;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import put.iosort.Config.Order;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
public class InsertionSortTest {

    @Autowired
    private InsertionSort insertionSort;

    @Test
    public void testInsertionSortIntArrayAscending() {
        int[] input = {5, 3, 8, 1};
        int[] expected = {1, 3, 5, 8};

        int[] result = insertionSort.sort(input, Order.ASC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortIntArrayDescending() {
        int[] input = {5, 3, 8, 1};
        int[] expected = {8, 5, 3, 1};

        int[] result = insertionSort.sort(input, Order.DESC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortIntArrayWithIterationsAscending() {
        int[] input = {5, 3, 8, 1};
        int[] expected = {3, 5, 8, 1};

        int[] result = insertionSort.sort(input, Order.ASC, 2);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortFloatArrayAscending() {
        float[] input = {5.5f, 3.3f, 8.8f, 1.1f};
        float[] expected = {1.1f, 3.3f, 5.5f, 8.8f};

        float[] result = insertionSort.sort(input, Order.ASC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortFloatArrayDescending() {
        float[] input = {5.5f, 3.3f, 8.8f, 1.1f};
        float[] expected = {8.8f, 5.5f, 3.3f, 1.1f};

        float[] result = insertionSort.sort(input, Order.DESC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortFloatArrayWithIterationsAscending() {
        float[] input = {5.5f, 3.3f, 8.8f, 1.1f};
        float[] expected = {3.3f, 5.5f, 8.8f, 1.1f};

        float[] result = insertionSort.sort(input, Order.ASC, 2);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortStringArrayAscending() {
        String[] input = {"banana", "apple", "cherry", "date"};
        String[] expected = {"apple", "banana", "cherry", "date"};

        String[] result = insertionSort.sort(input, Order.ASC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortStringArrayDescending() {
        String[] input = {"banana", "apple", "cherry", "date"};
        String[] expected = {"date", "cherry", "banana", "apple"};

        String[] result = insertionSort.sort(input, Order.DESC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSortStringArrayWithIterationsAscending() {
        String[] input = {"banana", "apple", "cherry", "date"};
        String[] expected = {"apple", "banana", "cherry", "date"};

        String[] result = insertionSort.sort(input, Order.ASC, 2);

        assertArrayEquals(expected, result);
    }
}