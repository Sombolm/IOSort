package put.iosort.Service.Strategies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Strategy.Strategy;

@Service
public class BubbleSort implements Strategy {

    private static final Logger logger = LoggerFactory.getLogger(BubbleSort.class);

    //-------------------FOR INT------------------
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

    private boolean compare(int a, int b, Order order) {
        return order == Order.ASC ? a > b : a < b;
    }

    //----------------------FOR FLOAT-----------------------
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

    private boolean compare(float a, float b, Order order) {
        return order == Order.ASC ? a > b : a < b;
    }

    //----------------------FOR STRING-----------------------
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

    private boolean compare(String a, String b, Order order) {
        return order == Order.ASC ? a.compareTo(b) > 0 : a.compareTo(b) < 0;
    }
}
