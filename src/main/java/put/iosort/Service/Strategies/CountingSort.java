package put.iosort.Service.Strategies;

import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Strategy.Strategy;

@Service
public class CountingSort implements Strategy {
    @Override
    public int[] sort(int[] array, Order order, int iterations) {
        int max = array[0];
        int min = array[0];

        for (int num : array) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int range = max - min + 1;
        int[] count = new int[range];

        if (order == Order.ASC) {
            for (int i = 1; i < range; i++) {
                count[i] += count[i - 1];
            }
        } else if (order == Order.DESC) {
            for (int i = range - 2; i >= 0; i--) {
                count[i] += count[i + 1];
            }
        }

        int[] sorted = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            int index = count[array[i] - min] - 1;
            sorted[index] = array[i];
            count[array[i] - min]--;

            if(i == iterations) {
                break;
            }
        }

        return sorted;
    }

    @Override
    public int[] sort(int[] array, Order order) {
        int max = array[0];
        int min = array[0];

        for (int num : array) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int range = max - min + 1;
        int[] count = new int[range];

        if (order == Order.ASC) {
            for (int i = 1; i < range; i++) {
                count[i] += count[i - 1];
            }
        } else if (order == Order.DESC) {
            for (int i = range - 2; i >= 0; i--) {
                count[i] += count[i + 1];
            }
        }

        int[] sorted = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            int index = count[array[i] - min] - 1;
            sorted[index] = array[i];
            count[array[i] - min]--;
        }

        return sorted;
    }
}
