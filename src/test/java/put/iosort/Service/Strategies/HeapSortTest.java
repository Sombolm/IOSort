package put.iosort.Service.Strategies;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import put.iosort.Config.Order;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HeapSortTest {

    private final HeapSort heapSort = new HeapSort();

    @Test
    void testHeapSortIntArrayAscending() {
        int[] input = {5, 3, 8, 6, 2};
        int[] expected = {2, 3, 5, 6, 8};
        int[] output = heapSort.sort(input, Order.ASC);
        assertArrayEquals(expected, output);
    }

    @Test
    void testHeapSortIntArrayDescending() {
        int[] input = {5, 3, 8, 6, 2};
        int[] expected = {8, 6, 5, 3, 2};
        int[] output = heapSort.sort(input, Order.DESC);
        assertArrayEquals(expected, output);
    }

    @Test
    void testHeapSortIntArrayWithIterationsAscending() {
        int[] input = {5, 3, 8, 6, 2};
        int[] expected = {3, 2, 5, 6, 8};
        int[] output = heapSort.sort(input, Order.ASC, 2);
        assertArrayEquals(expected, output);
    }

    @Test
    void testHeapSortFloatArrayAscending() {
        float[] input = {5.2f, 3.1f, 8.6f, 6.4f, 2.9f};
        float[] expected = {2.9f, 3.1f, 5.2f, 6.4f, 8.6f};
        float[] output = heapSort.sort(input, Order.ASC);
        assertArrayEquals(expected, output);
    }

    @Test
    void testHeapSortFloatArrayDescending() {
        float[] input = {5.2f, 3.1f, 8.6f, 6.4f, 2.9f};
        float[] expected = {8.6f, 6.4f, 5.2f, 3.1f, 2.9f};
        float[] output = heapSort.sort(input, Order.DESC);
        assertArrayEquals(expected, output);
    }

    @Test
    void testHeapSortFloatArrayWithIterationsAscending() {
        float[] input = {5.2f, 3.1f, 8.6f, 6.4f, 2.9f};
        float[] expected = {5.2f, 3.1f, 2.9f, 6.4f, 8.6f};
        float[] output = heapSort.sort(input, Order.ASC, 3);
        assertArrayEquals(expected, output);
    }

    @Test
    void testHeapSortStringArrayAscending() {
        String[] input = {"apple", "orange", "banana", "kiwi", "grape"};
        String[] expected = {"apple", "banana", "grape", "kiwi", "orange"};
        String[] output = heapSort.sort(input, Order.ASC);
        assertArrayEquals(expected, output);
    }

    @Test
    void testHeapSortStringArrayDescending() {
        String[] input = {"apple", "orange", "banana", "kiwi", "grape"};
        String[] expected = {"orange", "kiwi", "grape", "banana", "apple"};
        String[] output = heapSort.sort(input, Order.DESC);
        assertArrayEquals(expected, output);
    }

    @Test
    void testHeapSortStringArrayWithIterationsAscending() {
        String[] input = {"apple", "orange", "banana", "kiwi", "grape"};
        String[] expected = {"kiwi", "grape", "banana", "apple", "orange"};
        String[] output = heapSort.sort(input, Order.ASC, 4);
        assertArrayEquals(expected, output);
    }
}