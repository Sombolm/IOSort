package put.iosort.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Entity.SortingResult.SortingResult;
import put.iosort.Service.Factory.StrategyFactory;
import put.iosort.Service.Strategy.Strategy;
import put.iosort.Service.Strategy.StrategyType;

@Service
@AllArgsConstructor
public class Context {
    private final StrategyFactory strategyFactory;


    public SortingResult handleContext(int[] numbers, StrategyType strategyType, Order order, int iterations) {

        Strategy strategy = strategyFactory.makeStrategy(strategyType);


        long start = System.nanoTime();
        int[] sortedArray = strategy.sort(numbers, order, iterations);
        long end = System.nanoTime();
        long duration = end - start;

        return new SortingResult(sortedArray, duration);
    }

    public SortingResult handleContext(int[] numbers, StrategyType strategyType, Order order) {

        Strategy strategy = strategyFactory.makeStrategy(strategyType);


        long start = System.nanoTime();
        int[] sortedArray = strategy.sort(numbers, order);
        long end = System.nanoTime();
        long duration = end - start;

        return new SortingResult(sortedArray, duration);
    }
}
