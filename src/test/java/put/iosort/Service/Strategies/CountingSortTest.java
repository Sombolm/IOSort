package put.iosort.Service.Strategies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import put.iosort.Config.Order;

@SpringBootTest
class CountingSortTest {

    @Autowired
    private CountingSort countingSort;

    @Test
    void testCountingSortIntArrayAscending() {
        int[] input = {4, 2, 2, 8, 3, 3, 1};
        int[] expectedOutput = {1, 2, 2, 3, 3, 4, 8};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.ASC));
    }

    @Test
    void testCountingSortIntArrayDescending() {
        int[] input = {4, 2, 2, 8, 3, 3, 1};
        int[] expectedOutput = {8, 4, 3, 3, 2, 2, 1};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.DESC));
    }

    @Test
    void testCountingSortIntArrayWithIterationsAscending() {
        int[] input = {4, 2, 2, 8, 3, 3, 1};
        int[] expectedOutput = {1, 0, 0, 3, 3, 0, 0};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.ASC, 4));
    }

    @Test
    void testCountingSortIntArrayWithIterationsDescending() {
        int[] input = {4, 2, 2, 8, 3, 3, 1};
        int[] expectedOutput = {8, 0, 3, 3, 2, 2, 1};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.DESC, 1));
    }

    @Test
    void testCountingSortFloatArrayAscending() {
        float[] input = {4.0f, 2.0f, 2.0f, 8.0f, 3.0f, 3.0f, 1.0f};
        float[] expectedOutput = {1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 8.0f};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.ASC));
    }

    @Test
    void testCountingSortFloatArrayDescending() {
        float[] input = {4.0f, 2.0f, 2.0f, 8.0f, 3.0f, 3.0f, 1.0f};
        float[] expectedOutput = {8.0f, 4.0f, 3.0f, 3.0f, 2.0f, 2.0f, 1.0f};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.DESC));
    }

    @Test
    void testCountingSortStringArrayAscending() {
        String[] input = {"dog", "apple", "banana", "cat"};
        String[] expectedOutput = {"apple", "banana", "cat", "dog"};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.ASC));
    }

    @Test
    void testCountingSortStringArrayDescending() {
        String[] input = {"dog", "apple", "banana", "cat"};
        String[] expectedOutput = {"dog", "cat", "banana", "apple"};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.DESC));
    }

    @Test
    void testCountingSortStringArrayWithIterationsAscending() {
        String[] input = {"dog", "apple", "banana", "cat"};
        String[] expectedOutput = {"dog", "cat", "apple", "banana"};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.ASC, 2));
    }

    @Test
    void testCountingSortStringArrayWithIterationsDescending() {
        String[] input = {"dog", "apple", "banana", "cat"};
        String[] expectedOutput = {"banana", "apple", "cat", "dog"};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.DESC, 2));
    }
}