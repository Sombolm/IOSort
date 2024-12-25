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
    public void testSortIntArrayAscending() {
        int[] input = {5, 3, 8, 1};
        int[] expected = {1, 3, 5, 8};

        int[] result = insertionSort.sort(input, Order.ASC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortIntArrayDescending() {
        int[] input = {5, 3, 8, 1};
        int[] expected = {8, 5, 3, 1};

        int[] result = insertionSort.sort(input, Order.DESC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortIntArrayWithIterations() {
        int[] input = {5, 3, 8, 1};
        int[] expected = {3, 5, 8, 1};

        int[] result = insertionSort.sort(input, Order.ASC, 2);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortFloatArrayAscending() {
        float[] input = {5.5f, 3.3f, 8.8f, 1.1f};
        float[] expected = {1.1f, 3.3f, 5.5f, 8.8f};

        float[] result = insertionSort.sort(input, Order.ASC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortFloatArrayDescending() {
        float[] input = {5.5f, 3.3f, 8.8f, 1.1f};
        float[] expected = {8.8f, 5.5f, 3.3f, 1.1f};

        float[] result = insertionSort.sort(input, Order.DESC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortFloatArrayWithIterations() {
        float[] input = {5.5f, 3.3f, 8.8f, 1.1f};
        float[] expected = {3.3f, 5.5f, 8.8f, 1.1f};

        float[] result = insertionSort.sort(input, Order.ASC, 2);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortStringArrayAscending() {
        String[] input = {"banana", "apple", "cherry", "date"};
        String[] expected = {"apple", "banana", "cherry", "date"};

        String[] result = insertionSort.sort(input, Order.ASC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortStringArrayDescending() {
        String[] input = {"banana", "apple", "cherry", "date"};
        String[] expected = {"date", "cherry", "banana", "apple"};

        String[] result = insertionSort.sort(input, Order.DESC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSortStringArrayWithIterations() {
        String[] input = {"banana", "apple", "cherry", "date"};
        String[] expected = {"apple", "banana", "cherry", "date"};

        String[] result = insertionSort.sort(input, Order.ASC, 2);

        assertArrayEquals(expected, result);
    }
}