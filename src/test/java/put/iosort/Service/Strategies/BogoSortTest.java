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
}