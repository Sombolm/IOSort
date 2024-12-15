package put.iosort.Service.Strategy;

import org.springframework.stereotype.Component;
import put.iosort.Config.Order;

@Component
public interface Strategy {

    int[] sort(int[] array, Order order, int iterations);
    float[] sort(float[] array, Order order, int iterations);
    String[] sort(String[] array, Order order, int iterations);

    int[] sort(int[] array, Order order);
    float[] sort(float[] array, Order order);
    String[] sort(String[] array, Order order);
}
