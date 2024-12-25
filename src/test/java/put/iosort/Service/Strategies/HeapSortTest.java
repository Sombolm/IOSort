package put.iosort.Service.Strategies;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import put.iosort.Config.Order;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HeapSortTest {

    private final HeapSort heapSort = new HeapSort();

    @Test
    void testSortIntArrayAscending() {
        int[] input = {5, 3, 8, 6, 2};
        int[] expected = {2, 3, 5, 6, 8};
        int[] output = heapSort.sort(input, Order.ASC);
        assertArrayEquals(expected, output);
    }

    @Test
    void testSortIntArrayDescending() {
        int[] input = {5, 3, 8, 6, 2};
        int[] expected = {8, 6, 5, 3, 2};
        int[] output = heapSort.sort(input, Order.DESC);
        assertArrayEquals(expected, output);
    }

    @Test
    void testSortIntArrayWithIterations() {
        int[] input = {5, 3, 8, 6, 2};
        int[] output = heapSort.sort(input, Order.ASC, 2);
        assertEquals(5, output.length); 
    }

    @Test
    void testSortFloatArrayAscending() {
        float[] input = {5.2f, 3.1f, 8.6f, 6.4f, 2.9f};
        float[] expected = {2.9f, 3.1f, 5.2f, 6.4f, 8.6f};
        float[] output = heapSort.sort(input, Order.ASC);
        assertArrayEquals(expected, output);
    }

    @Test
    void testSortFloatArrayDescending() {
        float[] input = {5.2f, 3.1f, 8.6f, 6.4f, 2.9f};
        float[] expected = {8.6f, 6.4f, 5.2f, 3.1f, 2.9f};
        float[] output = heapSort.sort(input, Order.DESC);
        assertArrayEquals(expected, output);
    }

    @Test
    void testSortFloatArrayWithIterations() {
        float[] input = {5.2f, 3.1f, 8.6f, 6.4f, 2.9f};
        float[] output = heapSort.sort(input, Order.ASC, 3);
        assertEquals(5, output.length); 
    }

    @Test
    void testSortStringArrayAscending() {
        String[] input = {"apple", "orange", "banana", "kiwi", "grape"};
        String[] expected = {"apple", "banana", "grape", "kiwi", "orange"};
        String[] output = heapSort.sort(input, Order.ASC);
        assertArrayEquals(expected, output);
    }

    @Test
    void testSortStringArrayDescending() {
        String[] input = {"apple", "orange", "banana", "kiwi", "grape"};
        String[] expected = {"orange", "kiwi", "grape", "banana", "apple"};
        String[] output = heapSort.sort(input, Order.DESC);
        assertArrayEquals(expected, output);
    }

    @Test
    void testSortStringArrayWithIterations() {
        String[] input = {"apple", "orange", "banana", "kiwi", "grape"};
        String[] output = heapSort.sort(input, Order.ASC, 4);
        assertEquals(5, output.length); 
    }
}