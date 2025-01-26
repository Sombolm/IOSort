package put.iosort.Service.Strategies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    // Logger for this class
    private static final Logger logger = LoggerFactory.getLogger(BogoSort.class);

    //--------------------FOR INT-----------------------
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
        logger.info("Starting BogoSort for int[] with order: {} and max iterations: {}", order, iterations);

        while (iterations != 0) {
            if (isSorted(array, order)) {
                logger.info("Array is sorted after {} iterations.", iterations);
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
        logger.info("Starting BogoSort for int[] with order: {} and no iteration limit.", order);

        while (true) {
            if (isSorted(array, order)) {
                logger.info("Array is sorted.");
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

    //----------------FOR FLOAT-------------------
    @Override
    public float[] sort(float[] array, Order order, int iterations) {
        Random random = new Random();
        logger.info("Starting BogoSort for float[] with order: {} and max iterations: {}", order, iterations);

        while (iterations != 0) {
            if (isSorted(array, order)) {
                logger.info("Array is sorted after {} iterations.", iterations);
                break;
            }

            // Shuffle the array randomly
            for (int i = 0; i < array.length; i++) {
                int randomIndex = random.nextInt(array.length);
                float temp = array[i];
                array[i] = array[randomIndex];
                array[randomIndex] = temp;
            }

            iterations--;
        }

        return array;
    }

    @Override
    public float[] sort(float[] array, Order order) {
        Random random = new Random();
        logger.info("Starting BogoSort for float[] with order: {} and no iteration limit.", order);

        while (true) {
            if (isSorted(array, order)) {
                logger.info("Array is sorted.");
                break;
            }

            for (int i = 0; i < array.length; i++) {
                int randomIndex = random.nextInt(array.length);
                float temp = array[i];
                array[i] = array[randomIndex];
                array[randomIndex] = temp;
            }
        }
        return array;
    }

    private boolean isSorted(float[] array, Order order) {
        for (int i = 0; i < array.length - 1; i++) {
            if (compare(array[i], array[i + 1], order)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(float a, float b, Order order) {
        return order == Order.ASC ? a > b : a < b;
    }

    //----------------FOR STRING-------------------
    @Override
    public String[] sort(String[] array, Order order, int iterations) {
        Random random = new Random();
        logger.info("Starting BogoSort for String[] with order: {} and max iterations: {}", order, iterations);

        while (iterations != 0) {
            if (isSorted(array, order)) {
                logger.info("Array is sorted after {} iterations.", iterations);
                break;
            }

            // Shuffle the array randomly
            for (int i = 0; i < array.length; i++) {
                int randomIndex = random.nextInt(array.length);
                String temp = array[i];
                array[i] = array[randomIndex];
                array[randomIndex] = temp;
            }

            iterations--;
        }

        return array;
    }

    @Override
    public String[] sort(String[] array, Order order) {
        Random random = new Random();
        logger.info("Starting BogoSort for String[] with order: {} and no iteration limit.", order);

        while (true) {
            if (isSorted(array, order)) {
                logger.info("Array is sorted.");
                break;
            }

            for (int i = 0; i < array.length; i++) {
                int randomIndex = random.nextInt(array.length);
                String temp = array[i];
                array[i] = array[randomIndex];
                array[randomIndex] = temp;
            }
        }
        return array;
    }

    private boolean isSorted(String[] array, Order order) {
        for (int i = 0; i < array.length - 1; i++) {
            if (compare(array[i], array[i + 1], order)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String a, String b, Order order) {
        return order == Order.ASC ? a.compareTo(b) > 0 : a.compareTo(b) < 0;
    }


    @Override
    public int[] sortWithTimeLimit(int[] array, Order order, int iterations, long timeLimitNano) {
        Random random = new Random();
        logger.info("Starting BogoSort for int[] with order: {} and max iterations: {}", order, iterations);

        long startTime = System.nanoTime();

        while (iterations != 0) {
            if (isSorted(array, order)) {
                logger.info("Array is sorted after {} iterations.", iterations);
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

            if (timeLimitNano > 0 && (System.nanoTime() - startTime) >= timeLimitNano) {
                logger.info("Time limit of {} ms reached. Stopping sort.", timeLimitNano);
                break;
            }
        }

        return array;
    }

    @Override
    public String[] sortWithTimeLimit(String[] array, Order order, int iterations, long timeLimitNano) {
        Random random = new Random();
        logger.info("Starting BogoSort for String[] with order: {} and max iterations: {}", order, iterations);

        long startTime = System.nanoTime();

        while (iterations != 0) {
            if (isSorted(array, order)) {
                logger.info("Array is sorted after {} iterations.", iterations);
                break;
            }

            // Shuffle the array randomly
            for (int i = 0; i < array.length; i++) {
                int randomIndex = random.nextInt(array.length);
                String temp = array[i];
                array[i] = array[randomIndex];
                array[randomIndex] = temp;
            }

            iterations--;

            if (timeLimitNano > 0 && (System.nanoTime() - startTime) >= timeLimitNano) {
                logger.info("Time limit of {} ms reached. Stopping sort.", timeLimitNano);
                break;
            }
        }

        return array;
    }

    @Override
    public float[] sortWithTimeLimit(float[] array, Order order, int iterations, long timeLimitNano) {
        Random random = new Random();
        logger.info("Starting BogoSort for float[] with order: {} and max iterations: {}", order, iterations);

        long startTime = System.nanoTime();

        while (iterations != 0) {
            if (isSorted(array, order)) {
                logger.info("Array is sorted after {} iterations.", iterations);
                break;
            }

            // Shuffle the array randomly
            for (int i = 0; i < array.length; i++) {
                int randomIndex = random.nextInt(array.length);
                float temp = array[i];
                array[i] = array[randomIndex];
                array[randomIndex] = temp;
            }

            iterations--;

            if (timeLimitNano > 0 && (System.nanoTime() - startTime) >= timeLimitNano) {
                logger.info("Time limit of {} ms reached. Stopping sort.", timeLimitNano);
                break;
            }
        }

        return array;
    }

}
