package put.iosort.Service.Strategies;

import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Strategy.Strategy;

import java.util.Random;


@Service
public class BogoSort implements Strategy {

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

    private boolean isSorted(int[] array, Order order) {
        for (int i = 0; i < array.length - 1; i++) {
            if (compare(array[i], array[i + 1], order)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(int a, int b, Order order) {
        return order == Order.ASC ? a > b : a < b;
    }
}