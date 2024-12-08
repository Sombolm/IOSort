package put.iosort.Service.Strategies;

import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Strategy.Strategy;

@Service
public class BubbleSort implements Strategy {
    @Override
    public int[] sort(int[] array, Order order, int iterations) {
        int n = array.length;

        outerloop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (compare(array[j], array[j + 1], order)) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

                if (i * j == iterations) {
                    break outerloop;
                }
            }
        }
        return array;
    }

    private boolean compare(int a, int b, Order order) {
        return order == Order.ASC ? a > b : a < b;
    }
}
