package put.iosort.Service.Strategies;

import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Strategy.Strategy;

@Service
public class HeapSort implements Strategy {

    //----------FOR INT------------
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

            if (i == iterations) break;
        }

        return array;
    }

    @Override
    public int[] sort(int[] array, Order order) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, order);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0, order);
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
        return order == Order.ASC ? a > b : a < b;
    }

    //----------FOR FLOAT------------
    @Override
    public float[] sort(float[] array, Order order, int iterations) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, order);
        }

        for (int i = n - 1; i > 0; i--) {
            float temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0, order);

            if (i == iterations) break;
        }

        return array;
    }

    @Override
    public float[] sort(float[] array, Order order) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, order);
        }

        for (int i = n - 1; i > 0; i--) {
            float temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0, order);
        }

        return array;
    }

    private void heapify(float[] array, int n, int i, Order order) {
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
            float swap = array[i];
            array[i] = array[pivot];
            array[pivot] = swap;

            heapify(array, n, pivot, order);
        }
    }

    private boolean compare(float a, float b, Order order) {
        return order == Order.ASC ? a > b : a < b;
    }

    //----------FOR STRING------------
    @Override
    public String[] sort(String[] array, Order order, int iterations) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, order);
        }

        for (int i = n - 1; i > 0; i--) {
            String temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0, order);

            if (i == iterations) break;
        }

        return array;
    }

    @Override
    public String[] sort(String[] array, Order order) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, order);
        }

        for (int i = n - 1; i > 0; i--) {
            String temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0, order);
        }

        return array;
    }

    private void heapify(String[] array, int n, int i, Order order) {
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
            String swap = array[i];
            array[i] = array[pivot];
            array[pivot] = swap;

            heapify(array, n, pivot, order);
        }
    }

    private boolean compare(String a, String b, Order order) {
        return order == Order.ASC ? a.compareTo(b) > 0 : a.compareTo(b) < 0;
    }
}
