package put.iosort.Service.Strategies;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import put.iosort.Config.Order;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
public class SelectionSortTest {

    @Autowired
    private SelectionSort selectionSort;

    @Test
    public void testSelectionSortIntArrayAscending() {
        int[] input = {5, 3, 8, 6, 2};
        int[] expected = {2, 3, 5, 6, 8};

        int[] result = selectionSort.sort(input, Order.ASC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSelectionSortIntArrayDescending() {
        int[] input = {5, 3, 8, 6, 2};
        int[] expected = {8, 6, 5, 3, 2};

        int[] result = selectionSort.sort(input, Order.DESC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSelectionSortIntArrayWithIterationsAscending() {
        int[] input = {5, 3, 8, 6, 2};
        int[] expected = {2, 3, 5, 6, 8};

        int[] result = selectionSort.sort(input, Order.ASC, 2);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSelectionSortFloatArrayAscending() {
        float[] input = {5.5f, 3.3f, 8.8f, 6.6f, 2.2f};
        float[] expected = {2.2f, 3.3f, 5.5f, 6.6f, 8.8f};

        float[] result = selectionSort.sort(input, Order.ASC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSelectionSortFloatArrayDescending() {
        float[] input = {5.5f, 3.3f, 8.8f, 6.6f, 2.2f};
        float[] expected = {8.8f, 6.6f, 5.5f, 3.3f, 2.2f};

        float[] result = selectionSort.sort(input, Order.DESC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSelectionSortFloatArrayWithIterationsAscending() {
        float[] input = {5.5f, 3.3f, 8.8f, 6.6f, 2.2f};
        float[] expected = {2.2f, 3.3f, 5.5f, 6.6f, 8.8f};

        float[] result = selectionSort.sort(input, Order.ASC, 2);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSelectionSortStringArrayAscending() {
        String[] input = {"banana", "apple", "cherry", "date"};
        String[] expected = {"apple", "banana", "cherry", "date"};

        String[] result = selectionSort.sort(input, Order.ASC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSelectionSortStringArrayDescending() {
        String[] input = {"banana", "apple", "cherry", "date"};
        String[] expected = {"date", "cherry", "banana", "apple"};

        String[] result = selectionSort.sort(input, Order.DESC);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSelectionSortStringArrayWithIterationsAscending() {
        String[] input = {"banana", "apple", "cherry", "date"};
        String[] expected = {"apple", "banana", "cherry", "date"};

        String[] result = selectionSort.sort(input, Order.ASC, 1);

        assertArrayEquals(expected, result);
    }
}