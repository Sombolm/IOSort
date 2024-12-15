package put.iosort.Service.Strategies;

import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Strategy.Strategy;

@Service
public class InsertionSort implements Strategy {

    //-------------FOR INT---------------
    @Override
    public int[] sort(int[] array, Order order, int iterations) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && compare(array[j], key, order)) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
            if (iterations == i) {
                break;
            }
        }
        return array;
    }

    @Override
    public int[] sort(int[] array, Order order) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && compare(array[j], key, order)) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
        return array;
    }

    private boolean compare(int a, int b, Order order) {
        return order == Order.ASC ? a > b : a < b;
    }

    //-------------FOR FLOAT---------------
    @Override
    public float[] sort(float[] array, Order order, int iterations) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            float key = array[i];
            int j = i - 1;

            while (j >= 0 && compare(array[j], key, order)) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
            if (iterations == i) {
                break;
            }
        }
        return array;
    }

    @Override
    public float[] sort(float[] array, Order order) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            float key = array[i];
            int j = i - 1;

            while (j >= 0 && compare(array[j], key, order)) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
        return array;
    }

    private boolean compare(float a, float b, Order order) {
        return order == Order.ASC ? a > b : a < b;
    }

    //-------------FOR STRING---------------
    @Override
    public String[] sort(String[] array, Order order, int iterations) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            String key = array[i];
            int j = i - 1;

            while (j >= 0 && compare(array[j], key, order)) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
            if (iterations == i) {
                break;
            }
        }
        return array;
    }

    @Override
    public String[] sort(String[] array, Order order) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            String key = array[i];
            int j = i - 1;

            while (j >= 0 && compare(array[j], key, order)) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
        return array;
    }

    private boolean compare(String a, String b, Order order) {
        return order == Order.ASC ? a.compareTo(b) > 0 : a.compareTo(b) < 0;
    }
}
