package put.iosort.Service.Strategies;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import put.iosort.Config.Order;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
class BubbleSortTest {

    @Autowired
    private BubbleSort bubbleSort;

    @Test
    void testSortIntArrayAscending() {
        int[] input = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};

        int[] result = bubbleSort.sort(input, Order.ASC);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortIntArrayDescending() {
        int[] input = {5, 2, 9, 1, 5, 6};
        int[] expected = {9, 6, 5, 5, 2, 1};

        int[] result = bubbleSort.sort(input, Order.DESC);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortIntArrayWithIterationsAscending() {
        int[] input = {5, 2, 9, 1, 5, 6};
        int[] expected = {2, 5, 9, 1, 5, 6};

        int[] result = bubbleSort.sort(input, Order.ASC, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortFloatArrayAscending() {
        float[] input = {5.3f, 2.1f, 9.6f, 1.2f};
        float[] expected = {1.2f, 2.1f, 5.3f, 9.6f};

        float[] result = bubbleSort.sort(input, Order.ASC);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortFloatArrayDescending() {
        float[] input = {5.3f, 2.1f, 9.6f, 1.2f};
        float[] expected = {9.6f, 5.3f, 2.1f, 1.2f};

        float[] result = bubbleSort.sort(input, Order.DESC);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortFloatArrayWithIterationsDescending() {
        float[] input = {5.3f, 2.1f, 9.6f, 1.2f};
        float[] expected = {5.3f, 9.6f, 2.1f, 1.2f};

        float[] result = bubbleSort.sort(input, Order.DESC, 2);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortStringArrayAscending() {
        String[] input = {"apple", "orange", "banana", "pear"};
        String[] expected = {"apple", "banana", "orange", "pear"};

        String[] result = bubbleSort.sort(input, Order.ASC);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortStringArrayDescending() {
        String[] input = {"apple", "orange", "banana", "pear"};
        String[] expected = {"pear", "orange", "banana", "apple"};

        String[] result = bubbleSort.sort(input, Order.DESC);
        assertArrayEquals(expected, result);
    }

    @Test
    void testSortStringArrayWithIterationsAscending() {
        String[] input = {"apple", "orange", "banana", "pear"};
        String[] expected = {"apple", "banana", "orange", "pear"};

        String[] result = bubbleSort.sort(input, Order.ASC, 4);
        assertArrayEquals(expected, result);
    }
}