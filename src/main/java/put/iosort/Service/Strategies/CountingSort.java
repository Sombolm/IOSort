package put.iosort.Service.Strategies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Strategy.Strategy;

@Service
public class CountingSort implements Strategy {

    private static final Logger logger = LoggerFactory.getLogger(CountingSort.class);

    //-------------------FOR INT---------------------
    @Override
    public int[] sort(int[] array, Order order, int iterations) {
        logger.debug("Starting sort for int array with size: {} and order: {}", array.length, order);

        int N = array.length;
        int M = 0;

        for (int j : array) {
            M = Math.max(M, j);
        }

        int[] countArray = new int[M + 1];

        for (int j : array) {
            countArray[j]++;
        }

        if (order == Order.ASC) {
            for (int i = 1; i <= M; i++) {
                countArray[i] += countArray[i - 1];
            }
        } else if (order == Order.DESC) {
            for (int i = M - 1; i >= 0; i--) {
                countArray[i] += countArray[i + 1];
            }
        }

        int[] outputArray = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;

            if (i == iterations) {
                logger.debug("Breaking out of sort loop at iteration: {}", iterations);
                break;
            }
        }

        logger.debug("Sorting completed for int array");
        return outputArray;
    }

    @Override
    public int[] sort(int[] array, Order order) {
        logger.debug("Starting sort for int array with size: {} and order: {}", array.length, order);

        int N = array.length;
        int M = 0;

        for (int j : array) {
            M = Math.max(M, j);
        }

        int[] countArray = new int[M + 1];

        for (int j : array) {
            countArray[j]++;
        }

        if (order == Order.ASC) {
            for (int i = 1; i <= M; i++) {
                countArray[i] += countArray[i - 1];
            }
        } else if (order == Order.DESC) {
            for (int i = M - 1; i >= 0; i--) {
                countArray[i] += countArray[i + 1];
            }
        }

        int[] outputArray = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;
        }

        logger.debug("Sorting completed for int array");
        return outputArray;
    }

    //----------------FOR FLOAT-------------------
    @Override
    public float[] sort(float[] array, Order order, int iterations) {
        logger.debug("Starting sort for float array with size: {} and order: {}", array.length, order);

        int N = array.length;
        float M = 0;

        for (float j : array) {
            M = Math.max(M, j);
        }

        int[] countArray = new int[(int) M + 1];

        for (float j : array) {
            countArray[(int) j]++;
        }

        if (order == Order.ASC) {
            for (int i = 1; i <= M; i++) {
                countArray[i] += countArray[i - 1];
            }
        } else if (order == Order.DESC) {
            for (int i = (int) M - 1; i >= 0; i--) {
                countArray[i] += countArray[i + 1];
            }
        }

        float[] outputArray = new float[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[(int) array[i]] - 1] = array[i];
            countArray[(int) array[i]]--;

            if (i == iterations) {
                logger.debug("Breaking out of sort loop at iteration: {}", iterations);
                break;
            }
        }

        logger.debug("Sorting completed for float array");
        return outputArray;
    }

    @Override
    public float[] sort(float[] array, Order order) {
        logger.debug("Starting sort for float array with size: {} and order: {}", array.length, order);

        int N = array.length;
        float M = 0;

        for (float j : array) {
            M = Math.max(M, j);
        }

        int[] countArray = new int[(int) M + 1];

        for (float j : array) {
            countArray[(int) j]++;
        }

        if (order == Order.ASC) {
            for (int i = 1; i <= M; i++) {
                countArray[i] += countArray[i - 1];
            }
        } else if (order == Order.DESC) {
            for (int i = (int) M - 1; i >= 0; i--) {
                countArray[i] += countArray[i + 1];
            }
        }

        float[] outputArray = new float[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[(int) array[i]] - 1] = array[i];
            countArray[(int) array[i]]--;
        }

        logger.debug("Sorting completed for float array");
        return outputArray;
    }

    //----------------FOR STRING-------------------
    @Override
    public String[] sort(String[] array, Order order, int iterations) {
        logger.debug("Starting sort for string array with size: {} and order: {}", array.length, order);

        int N = array.length;

        // Find the maximum string length
        int maxLength = 0;
        for (String str : array) {
            maxLength = Math.max(maxLength, str.length());
        }

        // Perform counting sort for each character position, starting from the end
        for (int pos = maxLength - 1; pos >= 0; pos--) {
            int[] countArray = new int[256];

            // Count occurrences of characters at position 'pos'
            for (String str : array) {
                int charIndex = pos < str.length() ? str.charAt(pos) : 0;
                countArray[charIndex]++;
            }

            // Accumulate counts for sorting
            if (order == Order.ASC) {
                for (int i = 1; i < 256; i++) {
                    countArray[i] += countArray[i - 1];
                }
            } else {
                for (int i = 254; i >= 0; i--) {
                    countArray[i] += countArray[i + 1];
                }
            }

            // Build the sorted output array
            String[] outputArray = new String[N];
            for (int i = N - 1; i >= 0; i--) {
                int charIndex = pos < array[i].length() ? array[i].charAt(pos) : 0;
                outputArray[countArray[charIndex] - 1] = array[i];
                countArray[charIndex]--;

                if (iterations > 0 && --iterations == 0) {
                    logger.debug("Breaking out of sort loop at iteration: {}", iterations);
                    break;
                }
            }

            array = outputArray;
        }

        logger.debug("Sorting completed for string array");
        return array;
    }

    @Override
    public String[] sort(String[] array, Order order) {
        logger.debug("Starting sort for string array with size: {} and order: {}", array.length, order);

        int N = array.length;

        // Find the maximum string length
        int maxLength = 0;
        for (String str : array) {
            maxLength = Math.max(maxLength, str.length());
        }

        // Perform counting sort for each character position, starting from the end
        for (int pos = maxLength - 1; pos >= 0; pos--) {
            int[] countArray = new int[256];

            // Count occurrences of characters at position 'pos'
            for (String str : array) {
                int charIndex = pos < str.length() ? str.charAt(pos) : 0;
                countArray[charIndex]++;
            }

            // Accumulate counts for sorting
            if (order == Order.ASC) {
                for (int i = 1; i < 256; i++) {
                    countArray[i] += countArray[i - 1];
                }
            } else {
                for (int i = 254; i >= 0; i--) {
                    countArray[i] += countArray[i + 1];
                }
            }

            // Build the sorted output array
            String[] outputArray = new String[N];
            for (int i = N - 1; i >= 0; i--) {
                int charIndex = pos < array[i].length() ? array[i].charAt(pos) : 0;
                outputArray[countArray[charIndex] - 1] = array[i];
                countArray[charIndex]--;
            }

            array = outputArray;
        }

        logger.debug("Sorting completed for string array");
        return array;
    }
}
