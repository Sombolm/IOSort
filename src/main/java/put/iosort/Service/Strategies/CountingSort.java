package put.iosort.Service.Strategies;

import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Strategy.Strategy;

@Service
public class CountingSort implements Strategy {
    @Override
    public int[] sort(int[] array, Order order, int iterations) {
        int N = array.length;
        int M = 0;

        for (int j : array) {
            M = Math.max(M, j);
        }

        int[] countArray = new int[M + 1];

        for (int j : array) {
            countArray[j]++;
        }

        if(order == Order.ASC) {
            for (int i = 1; i <= M; i++) {
                countArray[i] += countArray[i - 1];
            }
        }
        else if (order == Order.DESC) {
            for (int i = M - 1; i >= 0; i--) {
                countArray[i] += countArray[i + 1];
            }
        }

        int[] outputArray = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;

            if(i == iterations) {
                break;
            }
        }

        return outputArray;
    }

    @Override
    public int[] sort(int[] array, Order order) {
        int N = array.length;
        int M = 0;

        for (int j : array) {
            M = Math.max(M, j);
        }

        int[] countArray = new int[M + 1];

        for (int j : array) {
            countArray[j]++;
        }

        if(order == Order.ASC) {
            for (int i = 1; i <= M; i++) {
                countArray[i] += countArray[i - 1];
            }
        }
        else if (order == Order.DESC) {
            for (int i = M - 1; i >= 0; i--) {
                countArray[i] += countArray[i + 1];
            }
        }

        int[] outputArray = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;
        }

        return outputArray;
    }
}
