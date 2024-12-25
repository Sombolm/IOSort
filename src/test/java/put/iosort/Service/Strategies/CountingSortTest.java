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
    void sortIntArrayAscending() {
        int[] input = {4, 2, 2, 8, 3, 3, 1};
        int[] expectedOutput = {1, 2, 2, 3, 3, 4, 8};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.ASC));
    }

    @Test
    void sortIntArrayDescending() {
        int[] input = {4, 2, 2, 8, 3, 3, 1};
        int[] expectedOutput = {8, 4, 3, 3, 2, 2, 1};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.DESC));
    }

    @Test
    void sortIntArrayWithIterationsAscending() {
        int[] input = {4, 2, 2, 8, 3, 3, 1};
        int[] expectedOutput = {1, 2, 2, 3, 3, 8, 0};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.ASC, 4));
    }

    @Test
    void sortIntArrayWithIterationsDescending() {
        int[] input = {4, 2, 2, 8, 3, 3, 1};
        int[] expectedOutput = {8, 4, 0, 0, 0, 0, 0};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.DESC, 1));
    }

    @Test
    void sortFloatArrayAscending() {
        float[] input = {4.0f, 2.0f, 2.0f, 8.0f, 3.0f, 3.0f, 1.0f};
        float[] expectedOutput = {1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 8.0f};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.ASC));
    }

    @Test
    void sortFloatArrayDescending() {
        float[] input = {4.0f, 2.0f, 2.0f, 8.0f, 3.0f, 3.0f, 1.0f};
        float[] expectedOutput = {8.0f, 4.0f, 3.0f, 3.0f, 2.0f, 2.0f, 1.0f};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.DESC));
    }

    @Test
    void sortStringArrayAscending() {
        String[] input = {"dog", "apple", "banana", "cat"};
        String[] expectedOutput = {"apple", "banana", "cat", "dog"};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.ASC));
    }

    @Test
    void sortStringArrayDescending() {
        String[] input = {"dog", "apple", "banana", "cat"};
        String[] expectedOutput = {"dog", "cat", "banana", "apple"};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.DESC));
    }

    @Test
    void sortStringArrayWithIterationsAscending() {
        String[] input = {"dog", "apple", "banana", "cat"};
        String[] expectedOutput = {"apple", "banana", "cat", "dog"};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.ASC, 2));
    }

    @Test
    void sortStringArrayWithIterationsDescending() {
        String[] input = {"dog", "apple", "banana", "cat"};
        String[] expectedOutput = {"dog", "cat", "banana", "apple"};
        assertArrayEquals(expectedOutput, countingSort.sort(input, Order.DESC, 2));
    }
}