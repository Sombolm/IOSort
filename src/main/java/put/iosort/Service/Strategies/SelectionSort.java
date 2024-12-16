package put.iosort.Service.Strategies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Strategy.Strategy;

@Service
public class SelectionSort implements Strategy {

    // Logger instance
    private static final Logger logger = LoggerFactory.getLogger(SelectionSort.class);

    //-------FOR INT---------
    @Override
    public int[] sort(int[] array, Order order, int iterations) {
        int n = array.length;

        logger.info("Starting Selection Sort for int array. Order: {}", order);

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (compare(array[j], array[minIndex], order)) {
                    minIndex = j;
                }
            }

            // Swap
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            logger.debug("Swapped elements at index {} and {}: {} <=> {}", i, minIndex, array[i], array[minIndex]);

            if (i == iterations) {
                logger.info("Reached specified iteration limit: {}. Stopping sort.", iterations);
                break;
            }
        }

        logger.info("Selection Sort completed for int array.");
        return array;
    }

    @Override
    public int[] sort(int[] array, Order order) {
        int n = array.length;

        logger.info("Starting Selection Sort for int array. Order: {}", order);

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (compare(array[j], array[minIndex], order)) {
                    minIndex = j;
                }
            }

            // Swap
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            logger.debug("Swapped elements at index {} and {}: {} <=> {}", i, minIndex, array[i], array[minIndex]);
        }

        logger.info("Selection Sort completed for int array.");
        return array;
    }

    private boolean compare(int a, int b, Order order) {
        return order == Order.ASC ? a < b : a > b;
    }

    //-------FOR FLOAT---------
    @Override
    public float[] sort(float[] array, Order order, int iterations) {
        int n = array.length;

        logger.info("Starting Selection Sort for float array. Order: {}", order);

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (compare(array[j], array[minIndex], order)) {
                    minIndex = j;
                }
            }

            // Swap
            float temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            logger.debug("Swapped elements at index {} and {}: {} <=> {}", i, minIndex, array[i], array[minIndex]);

            if (i == iterations) {
                logger.info("Reached specified iteration limit: {}. Stopping sort.", iterations);
                break;
            }
        }

        logger.info("Selection Sort completed for float array.");
        return array;
    }

    @Override
    public float[] sort(float[] array, Order order) {
        int n = array.length;

        logger.info("Starting Selection Sort for float array. Order: {}", order);

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (compare(array[j], array[minIndex], order)) {
                    minIndex = j;
                }
            }

            // Swap
            float temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            logger.debug("Swapped elements at index {} and {}: {} <=> {}", i, minIndex, array[i], array[minIndex]);
        }

        logger.info("Selection Sort completed for float array.");
        return array;
    }

    private boolean compare(float a, float b, Order order) {
        return order == Order.ASC ? a < b : a > b;
    }

    //-------FOR STRING---------
    @Override
    public String[] sort(String[] array, Order order, int iterations) {
        int n = array.length;

        logger.info("Starting Selection Sort for String array. Order: {}", order);

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (compare(array[j], array[minIndex], order)) {
                    minIndex = j;
                }
            }

            // Swap
            String temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            logger.debug("Swapped elements at index {} and {}: {} <=> {}", i, minIndex, array[i], array[minIndex]);

            if (i == iterations) {
                logger.info("Reached specified iteration limit: {}. Stopping sort.", iterations);
                break;
            }
        }

        logger.info("Selection Sort completed for String array.");
        return array;
    }

    @Override
    public String[] sort(String[] array, Order order) {
        int n = array.length;

        logger.info("Starting Selection Sort for String array. Order: {}", order);

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (compare(array[j], array[minIndex], order)) {
                    minIndex = j;
                }
            }

            // Swap
            String temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            logger.debug("Swapped elements at index {} and {}: {} <=> {}", i, minIndex, array[i], array[minIndex]);
        }

        logger.info("Selection Sort completed for String array.");
        return array;
    }

    private boolean compare(String a, String b, Order order) {
        return order == Order.ASC ? a.compareTo(b) < 0 : a.compareTo(b) > 0;
    }
}
