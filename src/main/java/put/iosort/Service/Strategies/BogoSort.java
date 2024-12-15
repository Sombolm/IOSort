package put.iosort.Service.Strategies;

import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Strategy.Strategy;

import java.util.Random;

/**
 * The {@code BogoSort} class implements the Bogo Sort algorithm as a sorting strategy.
 * This is a highly inefficient algorithm that works by randomly shuffling
 * the array until it becomes sorted. It is primarily intended for educational
 * purposes and not for practical use.
 */

@Service
public class BogoSort implements Strategy {

    /**
     * Sorts the given array using the Bogo Sort algorithm with a limited
     * number of iterations.
     *
     * @param array      The array of integers to be sorted.
     * @param order      The desired sorting order (ascending or descending).
     *                   {@code Order.ASC} for ascending order, {@code Order.DESC} for descending order.
     * @param iterations The maximum number of shuffles allowed.
     * @return The sorted array, or the current state of the array if the
     *         iteration limit is reached before sorting.
     */
    @Override
    public int[] sort(int[] array, Order order, int iterations) {
        Random random = new Random();

        while (iterations != 0) {
            if (isSorted(array, order)) {
                break;
            }

            // Shuffle the array randomly
            for (int i = 0; i < array.length; i++) {
                int randomIndex = random.nextInt(array.length);
                int temp = array[i];
                array[i] = array[randomIndex];
                array[randomIndex] = temp;
            }

            iterations--;
        }

        return array;
    }

    /**
     * Sorts the given array using the Bogo Sort algorithm with no iteration limit.
     * This method may run indefinitely if the input array is large or poorly shuffled.
     *
     * @param array The array of integers to be sorted.
     * @param order The desired sorting order (ascending or descending).
     *              {@code Order.ASC} for ascending order, {@code Order.DESC} for descending order.
     * @return The sorted array.
     */
    @Override
    public int[] sort(int[] array, Order order) {
        Random random = new Random();

        while (true) {
            if (isSorted(array, order)) {
                break;
            }

            for (int i = 0; i < array.length; i++) {
                int randomIndex = random.nextInt(array.length);
                int temp = array[i];
                array[i] = array[randomIndex];
                array[randomIndex] = temp;
            }

        }
        return array;
    }

    /**
     * Checks if the given array is sorted in the specified order.
     *
     * @param array The array to check.
     * @param order The desired sorting order (ascending or descending).
     * @return {@code true} if the array is sorted in the given order, {@code false} otherwise.
     */
    private boolean isSorted(int[] array, Order order) {
        for (int i = 0; i < array.length - 1; i++) {
            if (compare(array[i], array[i + 1], order)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares two integers based on the desired sorting order.
     *
     * @param a     The first integer.
     * @param b     The second integer.
     * @param order The desired sorting order (ascending or descending).
     * @return {@code true} if the integers are not in the correct order, {@code false} otherwise.
     */
    private boolean compare(int a, int b, Order order) {
        return order == Order.ASC ? a > b : a < b;
    }
}