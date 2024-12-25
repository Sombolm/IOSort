package put.iosort.Service.Strategies;

import org.junit.jupiter.api.Test;
import put.iosort.Config.Order;

import static org.junit.jupiter.api.Assertions.*;

class BogoSortTest {
    private final BogoSort bogoSort = new BogoSort();

    @Test
    void testSortUntilFinishedAscending() {
        int[] array = {3, 2, 1};
        int[] sortedArray = bogoSort.sort(array, Order.ASC, -1);

        assertTrue(isSorted(sortedArray, Order.ASC));
    }

    @Test
    void testSortUntilFinishedDescending() {
        int[] array = {1, 2, 3};
        int[] sortedArray = bogoSort.sort(array, Order.DESC, -1);

        assertTrue(isSorted(sortedArray, Order.DESC));
    }

    private boolean isSorted(int[] array, Order order) {
        for (int i = 0; i < array.length - 1; i++) {
            if ((order == Order.ASC && array[i] > array[i + 1]) ||
                    (order == Order.DESC && array[i] < array[i + 1])) {
                return false;
            }
        }
        return true;
    }


    @Test
    void testSortFloatArrayWithIterationsAscending() {
        float[] array = {3.3f, 2.2f, 1.1f};
        float[] sortedArray = bogoSort.sort(array, Order.ASC, 1000);

        assertTrue(isSorted(sortedArray, Order.ASC));
    }

    @Test
    void testSortFloatArrayWithIterationsDescending() {
        float[] array = {1.1f, 2.2f, 3.3f};
        float[] sortedArray = bogoSort.sort(array, Order.DESC, 1000);

        assertTrue(isSorted(sortedArray, Order.DESC));
    }

    @Test
    void testSortFloatArrayWithoutIterationsAscending() {
        float[] array = {3.3f, 2.2f, 1.1f};
        float[] sortedArray = bogoSort.sort(array, Order.ASC);

        assertTrue(isSorted(sortedArray, Order.ASC));
    }

    @Test
    void testSortFloatArrayWithoutIterationsDescending() {
        float[] array = {1.1f, 2.2f, 3.3f};
        float[] sortedArray = bogoSort.sort(array, Order.DESC);

        assertTrue(isSorted(sortedArray, Order.DESC));
    }

    @Test
    void testSortStringArrayWithIterationsAscending() {
        String[] array = {"c", "b", "a"};
        String[] sortedArray = bogoSort.sort(array, Order.ASC, 1000);

        assertTrue(isSorted(sortedArray, Order.ASC));
    }

    @Test
    void testSortStringArrayWithIterationsDescending() {
        String[] array = {"a", "b", "c"};
        String[] sortedArray = bogoSort.sort(array, Order.DESC, 1000);

        assertTrue(isSorted(sortedArray, Order.DESC));
    }

    @Test
    void testSortStringArrayWithoutIterationsAscending() {
        String[] array = {"c", "b", "a"};
        String[] sortedArray = bogoSort.sort(array, Order.ASC);

        assertTrue(isSorted(sortedArray, Order.ASC));
    }

    @Test
    void testSortStringArrayWithoutIterationsDescending() {
        String[] array = {"a", "b", "c"};
        String[] sortedArray = bogoSort.sort(array, Order.DESC);

        assertTrue(isSorted(sortedArray, Order.DESC));
    }

    private boolean isSorted(float[] array, Order order) {
        for (int i = 0; i < array.length - 1; i++) {
            if ((order == Order.ASC && array[i] > array[i + 1]) ||
                    (order == Order.DESC && array[i] < array[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(String[] array, Order order) {
        for (int i = 0; i < array.length - 1; i++) {
            if ((order == Order.ASC && array[i].compareTo(array[i + 1]) > 0) ||
                    (order == Order.DESC && array[i].compareTo(array[i + 1]) < 0)) {
                return false;
            }
        }
        return true;
    }
}