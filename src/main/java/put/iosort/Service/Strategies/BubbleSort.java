package put.iosort.Service.Strategies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Strategy.Strategy;

/**
 * The {@code BubbleSort} class implements the {@link Strategy} interface and provides sorting functionality
 * using the Bubble Sort algorithm. This class supports sorting for integers, floats, and strings with options
 * for iteration limits and time constraints.
 *
 * <p><b>Features:</b></p>
 * <ul>
 *     <li>Sorts arrays of integers, floats, and strings in ascending or descending order.</li>
 *     <li>Supports iteration limits to stop the sorting process after a specified number of steps.</li>
 *     <li>Supports time constraints to stop the sorting process after a specified duration.</li>
 *     <li>Logs detailed debug information for each comparison and swap operation.</li>
 * </ul>
 *
 * <p><b>Usage:</b></p>
 * <pre>
 *     BubbleSort bubbleSort = new BubbleSort();
 *     int[] sortedArray = bubbleSort.sort(array, Order.ASC, 100);
 * </pre>
 *
 * @see Strategy
 * @see Order
 * @author caprimol
 * @version 1.0
 * @since 2025-01-27
 */

@Service
public class BubbleSort implements Strategy {

    private static final Logger logger = LoggerFactory.getLogger(BubbleSort.class);

    //-------------------FOR INT------------------
    /**
     * Sorts an integer array using the Bubble Sort algorithm with a specified iteration limit.
     *
     * @param array      the integer array to be sorted.
     * @param order      the {@link Order} specifying ascending or descending order.
     * @param iterations the maximum number of iterations for sorting.
     * @return the sorted integer array.
     */
    @Override
    public int[] sort(int[] array, Order order, int iterations) {
        logger.info("Starting BubbleSort for int array with {} iterations.", iterations);
        int n = array.length;

        outerloop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                logger.debug("Comparing elements: {} and {}", array[j], array[j + 1]);
                if (compare(array[j], array[j + 1], order)) {
                    logger.debug("Swapping elements: {} and {}", array[j], array[j + 1]);
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

                if (i * j == iterations) {
                    logger.info("Reached iteration limit, stopping sorting.");
                    break outerloop;
                }
            }
        }
        logger.info("Sorting completed.");
        return array;
    }

    /**
     * Sorts an integer array using the Bubble Sort algorithm without an iteration limit.
     *
     * @param array the integer array to be sorted.
     * @param order the {@link Order} specifying ascending or descending order.
     * @return the sorted integer array.
     */
    @Override
    public int[] sort(int[] array, Order order) {
        logger.info("Starting BubbleSort for int array without iteration limit.");
        int n = array.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                logger.debug("Comparing elements: {} and {}", array[j], array[j + 1]);
                if (compare(array[j], array[j + 1], order)) {
                    logger.debug("Swapping elements: {} and {}", array[j], array[j + 1]);
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        logger.info("Sorting completed.");
        return array;
    }

    /**
     * Compares two integer elements based on the specified sorting order.
     *
     * @param a     the first element.
     * @param b     the second element.
     * @param order the {@link Order} specifying ascending or descending order.
     * @return {@code true} if the elements need to be swapped; {@code false} otherwise.
     */
    private boolean compare(int a, int b, Order order) {
        return order == Order.ASC ? a > b : a < b;
    }

    //----------------------FOR FLOAT-----------------------
    /**
     * Sorts a float array using the Bubble Sort algorithm with a specified iteration limit.
     *
     * @param array      the float array to be sorted.
     * @param order      the {@link Order} specifying ascending or descending order.
     * @param iterations the maximum number of iterations for sorting.
     * @return the sorted float array.
     */
    @Override
    public float[] sort(float[] array, Order order, int iterations) {
        logger.info("Starting BubbleSort for float array with {} iterations.", iterations);
        int n = array.length;

        outerloop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                logger.debug("Comparing elements: {} and {}", array[j], array[j + 1]);
                if (compare(array[j], array[j + 1], order)) {
                    logger.debug("Swapping elements: {} and {}", array[j], array[j + 1]);
                    float temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

                if (i * j == iterations) {
                    logger.info("Reached iteration limit, stopping sorting.");
                    break outerloop;
                }
            }
        }
        logger.info("Sorting completed.");
        return array;
    }

    /**
     * Sorts a float array using the Bubble Sort algorithm without an iteration limit.
     *
     * @param array the float array to be sorted.
     * @param order the {@link Order} specifying ascending or descending order.
     * @return the sorted float array.
     */
    @Override
    public float[] sort(float[] array, Order order) {
        logger.info("Starting BubbleSort for float array without iteration limit.");
        int n = array.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                logger.debug("Comparing elements: {} and {}", array[j], array[j + 1]);
                if (compare(array[j], array[j + 1], order)) {
                    logger.debug("Swapping elements: {} and {}", array[j], array[j + 1]);
                    float temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        logger.info("Sorting completed.");
        return array;
    }

    /**
     * Compares two float elements based on the specified sorting order.
     *
     * @param a     the first element.
     * @param b     the second element.
     * @param order the {@link Order} specifying ascending or descending order.
     * @return {@code true} if the elements need to be swapped; {@code false} otherwise.
     */
    private boolean compare(float a, float b, Order order) {
        return order == Order.ASC ? a > b : a < b;
    }

    //----------------------FOR STRING-----------------------
    /**
     * Sorts a string array using the Bubble Sort algorithm with a specified iteration limit.
     *
     * @param array      the string array to be sorted.
     * @param order      the {@link Order} specifying ascending or descending order.
     * @param iterations the maximum number of iterations for sorting.
     * @return the sorted string array.
     */
    @Override
    public String[] sort(String[] array, Order order, int iterations) {
        logger.info("Starting BubbleSort for String array with {} iterations.", iterations);
        int n = array.length;

        outerloop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                logger.debug("Comparing elements: {} and {}", array[j], array[j + 1]);
                if (compare(array[j], array[j + 1], order)) {
                    logger.debug("Swapping elements: {} and {}", array[j], array[j + 1]);
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

                if (i * j == iterations) {
                    logger.info("Reached iteration limit, stopping sorting.");
                    break outerloop;
                }
            }
        }
        logger.info("Sorting completed.");
        return array;
    }

    /**
     * Sorts a string array using the Bubble Sort algorithm without an iteration limit.
     *
     * @param array the string array to be sorted.
     * @param order the {@link Order} specifying ascending or descending order.
     * @return the sorted string array.
     */
    @Override
    public String[] sort(String[] array, Order order) {
        logger.info("Starting BubbleSort for String array without iteration limit.");
        int n = array.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                logger.debug("Comparing elements: {} and {}", array[j], array[j + 1]);
                if (compare(array[j], array[j + 1], order)) {
                    logger.debug("Swapping elements: {} and {}", array[j], array[j + 1]);
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        logger.info("Sorting completed.");
        return array;
    }

    /**
     * Compares two string elements based on the specified sorting order.
     *
     * @param a     the first element.
     * @param b     the second element.
     * @param order the {@link Order} specifying ascending or descending order.
     * @return {@code true} if the elements need to be swapped; {@code false} otherwise.
     */
    private boolean compare(String a, String b, Order order) {
        return order == Order.ASC ? a.compareTo(b) > 0 : a.compareTo(b) < 0;
    }

    /**
     * Sorts an integer array using the Bubble Sort algorithm with iteration and time constraints.
     *
     * @param array          the integer array to be sorted.
     * @param order          the {@link Order} specifying ascending or descending order.
     * @param iterations     the maximum number of iterations for sorting.
     * @param timeLimitNano  the time limit in nanoseconds for the sorting operation.
     * @return the partially or fully sorted integer array.
     */
    @Override
    public int[] sortWithTimeLimit(int[] array, Order order, int iterations, long timeLimitNano) {
        logger.info("Starting BubbleSort for int array with {} iterations and time limit {} ms.", iterations, timeLimitNano);
        int n = array.length;
        long startTime = System.nanoTime();

        outerloop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                logger.debug("Comparing elements: {} and {}", array[j], array[j + 1]);
                if (compare(array[j], array[j + 1], order)) {
                    logger.debug("Swapping elements: {} and {}", array[j], array[j + 1]);
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

                if (i * j == iterations) {
                    logger.info("Reached iteration limit, stopping sorting.");
                    break outerloop;
                }

                if (timeLimitNano > 0 && (System.nanoTime() - startTime) >= timeLimitNano) {
                    logger.info("Time limit of {} ms reached, stopping sorting.", timeLimitNano);
                    break outerloop;
                }
            }
        }
        logger.info("Sorting completed.");
        return array;
    }


    /**
     * Sorts a string array using the Bubble Sort algorithm with iteration and time constraints.
     *
     * @param array          the string array to be sorted.
     * @param order          the {@link Order} specifying ascending or descending order.
     * @param iterations     the maximum number of iterations for sorting.
     * @param timeLimitNano  the time limit in nanoseconds for the sorting operation.
     * @return the partially or fully sorted string array.
     */
    @Override
    public String[] sortWithTimeLimit(String[] array, Order order, int iterations, long timeLimitNano) {
        logger.info("Starting BubbleSort for String array with {} iterations and time limit {} ms.", iterations, timeLimitNano);
        int n = array.length;
        long startTime = System.nanoTime();

        outerloop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                logger.debug("Comparing elements: '{}' and '{}'", array[j], array[j + 1]);
                if (compare(array[j], array[j + 1], order)) {
                    logger.debug("Swapping elements: '{}' and '{}'", array[j], array[j + 1]);
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

                if (i * j == iterations) {
                    logger.info("Reached iteration limit, stopping sorting.");
                    break outerloop;
                }

                if (timeLimitNano > 0 && (System.nanoTime() - startTime) >= timeLimitNano) {
                    logger.info("Time limit of {} ms reached, stopping sorting.", timeLimitNano);
                    break outerloop;
                }
            }
        }
        logger.info("Sorting completed.");
        return array;
    }

    /**
     * Sorts a float array using the Bubble Sort algorithm with iteration and time constraints.
     *
     * @param array          the float array to be sorted.
     * @param order          the {@link Order} specifying ascending or descending order.
     * @param iterations     the maximum number of iterations for sorting.
     * @param timeLimitNano  the time limit in nanoseconds for the sorting operation.
     * @return the partially or fully sorted float array.
     */
    @Override
    public float[] sortWithTimeLimit(float[] array, Order order, int iterations, long timeLimitNano) {
        logger.info("Starting BubbleSort for float array with {} iterations and time limit {} ms.", iterations, timeLimitNano);
        int n = array.length;
        long startTime = System.nanoTime();

        outerloop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                logger.debug("Comparing elements: {} and {}", array[j], array[j + 1]);
                if (compare(array[j], array[j + 1], order)) {
                    logger.debug("Swapping elements: {} and {}", array[j], array[j + 1]);
                    float temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

                if (i * j == iterations) {
                    logger.info("Reached iteration limit, stopping sorting.");
                    break outerloop;
                }

                if (timeLimitNano > 0 && (System.nanoTime() - startTime) >= timeLimitNano) {
                    logger.info("Time limit of {} ms reached, stopping sorting.", timeLimitNano);
                    break outerloop;
                }
            }
        }
        logger.info("Sorting completed.");
        return array;
    }
}
