package put.iosort.Service.Strategies;

import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Strategy.Strategy;

@Service
public class BubbleSort implements Strategy {
    @Override
    public int[] sort(int[] array, Order order) {
        return new int[0];
    }
}
