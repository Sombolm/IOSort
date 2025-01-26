package put.iosort.Service.Strategies;

import java.util.Arrays;

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

        // Szukamy najdłuższego stringa w tablicy
        int maxLength = 0;
        for (String str : array) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }

        // Dokładanie spacji do stringów, żeby wyrównać ich długość
        String[] paddedArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            paddedArray[i] = padRight(array[i], maxLength);
        }

        // Counting sort dla każdej pozycji znaku, zaczynając od najmniej znaczącego
        int iterationsPerformed = 0;
        for (int position = maxLength - 1; position >= 0 && iterationsPerformed < iterations; position--) {
            countingSortByCharacter(paddedArray, position);
            iterationsPerformed++;
        }
        logger.debug("Breaking out of sort loop at iteration: {}", iterations);

        // Nałożony padding trzeba usunąć
        for (int i = 0; i < paddedArray.length; i++) {
            paddedArray[i] = paddedArray[i].trim();
        }

        // Odwracamy listę, jeśli porządek ma być malejący
        if (order == Order.DESC) {
            reverseArray(paddedArray);
        }

        logger.debug("Sorting completed for string array");
        return paddedArray;
    }

    @Override
    public String[] sort(String[] array, Order order) {
        logger.debug("Starting sort for string array with size: {} and order: {}", array.length, order);

        // Szukamy najdłuższego stringa w tablicy
        int maxLength = 0;
        for (String str : array) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }

        // Dokładanie spacji do stringów, żeby wyrównać ich długość
        String[] paddedArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            paddedArray[i] = padRight(array[i], maxLength);
        }

        // Counting sort dla każdej pozycji znaku, zaczynając od najmniej znaczącego
        for (int position = maxLength - 1; position >= 0; position--) {
            countingSortByCharacter(paddedArray, position);
        }

        // Nałożony padding trzeba usunąć
        for (int i = 0; i < paddedArray.length; i++) {
            paddedArray[i] = paddedArray[i].trim();
        }

        // Odwracamy listę, jeśli porządek ma być malejący
        if (order == Order.DESC) {
            reverseArray(paddedArray);
        }

        logger.debug("Sorting completed for string array");
        return paddedArray;
    }

    private void countingSortByCharacter(String[] array, int position) {
        int n = array.length;
        String[] outputArray = new String[n];

        // Counting array dla ASCII (0-255)
        int[] count = new int[256];
        Arrays.fill(count, 0);

        // Licz pojawienia się znaków na konkretnej pozycji
        for (String str : array) {
            char c = str.charAt(position);
            count[c]++;
        }

        // Aktualizacja Counting array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Złóż w całość wynik iteracji
        for (int i = n - 1; i >= 0; i--) {
            char c = array[i].charAt(position);
            outputArray[count[c] - 1] = array[i];
            count[c]--;
        }

        // Przekopiowuje posortowane dane bezposrednio do arguementu
        System.arraycopy(outputArray, 0, array, 0, n);
    }

    private String padRight(String str, int length) {
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < length) {
            sb.append(' ');
        }
        return sb.toString();
    }

    private void reverseArray(String[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            String temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }


    @Override
    public int[] sortWithTimeLimit(int[] array, Order order, int iterations, long timeLimitNano) {
        logger.debug("Starting sort for int array with size: {} and order: {}", array.length, order);

        int N = array.length;
        int M = 0;
        long startTime = System.nanoTime();

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

            if (timeLimitNano > 0 && (System.nanoTime() - startTime) >= timeLimitNano) {
                logger.info("Time limit of {} ms reached, stopping sorting.", timeLimitNano);
                break;
            }
        }

        logger.debug("Sorting completed for int array");
        return outputArray;
    }

    @Override
    public String[] sortWithTimeLimit(String[] array, Order order, int iterations, long timeLimitNano) {
        logger.debug("Starting sort for string array with size: {} and order: {}", array.length, order);

        // Szukamy najdłuższego stringa w tablicy
        int maxLength = 0;
        for (String str : array) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }

        // Dokładanie spacji do stringów, żeby wyrównać ich długość
        String[] paddedArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            paddedArray[i] = padRight(array[i], maxLength);
        }

        // Counting sort dla każdej pozycji znaku, zaczynając od najmniej znaczącego
        int iterationsPerformed = 0;
        long startTime = System.nanoTime();
        for (int position = maxLength - 1; position >= 0 && iterationsPerformed < iterations; position--) {
            countingSortByCharacter(paddedArray, position);
            iterationsPerformed++;

            if (timeLimitNano > 0 && (System.nanoTime() - startTime) >= timeLimitNano) {
                logger.info("Time limit of {} ms reached, stopping sorting.", timeLimitNano);
                break;
            }
        }
        logger.debug("Breaking out of sort loop at iteration: {}", iterations);

        // Nałożony padding trzeba usunąć
        for (int i = 0; i < paddedArray.length; i++) {
            paddedArray[i] = paddedArray[i].trim();
        }

        // Odwracamy listę, jeśli porządek ma być malejący
        if (order == Order.DESC) {
            reverseArray(paddedArray);
        }

        logger.debug("Sorting completed for string array");
        return paddedArray;
    }
        @Override
        public float[] sortWithTimeLimit ( float[] array, Order order,int iterations, long timeLimitNano){
            logger.debug("Starting sort for float array with size: {} and order: {}", array.length, order);

            int N = array.length;
            long startTime = System.nanoTime();

            float maxValue = Float.MIN_VALUE;
            for (float value : array) {
                maxValue = Math.max(maxValue, value);
            }

            int[] countArray = new int[(int) maxValue + 1];

            for (float value : array) {
                countArray[(int) value]++;
            }

            if (order == Order.ASC) {
                for (int i = 1; i < countArray.length; i++) {
                    countArray[i] += countArray[i - 1];
                }
            } else if (order == Order.DESC) {
                for (int i = countArray.length - 2; i >= 0; i--) {
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

                if (timeLimitNano > 0 && (System.nanoTime() - startTime) >= timeLimitNano) {
                    logger.info("Time limit of {} ms reached, stopping sorting.", timeLimitNano);
                    break;
                }
            }

            logger.debug("Sorting completed for float array");
            return outputArray;
        }

}
