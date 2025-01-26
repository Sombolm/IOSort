package put.iosort.Service.Strategies;

import org.junit.jupiter.api.Test;
import put.iosort.Config.Order;

import static org.junit.jupiter.api.Assertions.*;

class BogoSortTest {
    private final BogoSort bogoSort = new BogoSort();

    @Test
    void testBogoSortIntArrayAscending() {
        int[] input = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};

        int[] result = bogoSort.sort(input, Order.ASC);

        assertArrayEquals(expected, result);
    }

    @Test
    void testBogoSortIntArrayDescending() {
        int[] input = {5, 2, 9, 1, 5, 6};
        int[] expected = {9, 6, 5, 5, 2, 1};


        int[] result = bogoSort.sort(input, Order.DESC);

        assertArrayEquals(expected, result);
    }

    @Test
    void testBogoSortFloatArrayAscending() {
        float[] input = {5.3f, 2.1f, 9.6f, 1.2f};
        float[] expected = {1.2f, 2.1f, 5.3f, 9.6f};

        float[] result = bogoSort.sort(input, Order.ASC);
        assertArrayEquals(expected, result);
    }

    @Test
    void testBogoSortFloatArrayDescending() {
        float[] input = {5.3f, 2.1f, 9.6f, 1.2f};
        float[] expected = {9.6f, 5.3f, 2.1f, 1.2f};

        float[] result = bogoSort.sort(input, Order.DESC);
        assertArrayEquals(expected, result);
    }

    @Test
    void testbogoSortStringArrayAscending() {
        String[] input = {"apple", "orange", "banana", "pear"};
        String[] expected = {"apple", "banana", "orange", "pear"};

        String[] result = bogoSort.sort(input, Order.ASC);
        assertArrayEquals(expected, result);
    }

    @Test
    void testBogoSortStringArrayDescending() {
        String[] input = {"apple", "orange", "banana", "pear"};
        String[] expected = {"pear", "orange", "banana", "apple"};

        String[] result = bogoSort.sort(input, Order.DESC);
        assertArrayEquals(expected, result);
    }
}