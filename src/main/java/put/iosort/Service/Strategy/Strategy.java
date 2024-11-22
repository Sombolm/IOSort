package put.iosort.Service.Strategy;

import org.springframework.stereotype.Component;
import put.iosort.Config.Order;

@Component
public interface Strategy {

    int[] sort(int[] array, Order order, int iterations);
}
