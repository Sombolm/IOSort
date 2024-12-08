package put.iosort.Service.Strategies;

import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Strategy.Strategy;

@Service
public class HeapSort implements Strategy {
    @Override
    public int[] sort(int[] array, Order order, int iterations) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, order);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0, order);
            iterations--;
            if (iterations <= 0) return array;
        }

        return array;
    }

    private void heapify(int[] array, int n, int i, Order order) {
        int pivot = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && compare(array[left], array[pivot], order)) {
            pivot = left;
        }

        if (right < n && compare(array[right], array[pivot], order)) {
            pivot = right;
        }

        if (pivot != i) {
            int swap = array[i];
            array[i] = array[pivot];
            array[pivot] = swap;

            heapify(array, n, pivot, order);
        }
    }

    private boolean compare(int a, int b, Order order) {
        if (order == Order.ASC) {
            return a > b;
        } else {
            return a < b;
        }
    }
}
