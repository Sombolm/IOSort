package put.iosort.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Entity.SortingResult.SortingResult;
import put.iosort.Service.Factory.StrategyFactory;
import put.iosort.Service.Strategy.Strategy;
import put.iosort.Service.Strategy.StrategyType;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class Context {
    private final StrategyFactory strategyFactory;


    public List<SortingResult> handleContext(int[] numbers, StrategyType[] strategyTypes, Order order, int iterations) {
        List<SortingResult> sortingResults = new ArrayList<SortingResult>();

        for (StrategyType strategyType : strategyTypes) {
            Strategy strategy = strategyFactory.makeStrategy(strategyType);

            long start = System.nanoTime();
            numbers = strategy.sort(numbers, order, iterations);
            long end = System.nanoTime();
            long duration = end - start;

            SortingResult sortingResult = new SortingResult(numbers, duration);

            sortingResults.add(sortingResult);
        }

        return sortingResults;
    }

    public List<SortingResult> handleContext(int[] numbers, StrategyType[] strategyTypes, Order order) {
        List<SortingResult> sortingResults = new ArrayList<SortingResult>();

        for (StrategyType strategyType : strategyTypes) {
            Strategy strategy = strategyFactory.makeStrategy(strategyType);

            long start = System.nanoTime();
            numbers = strategy.sort(numbers, order);
            long end = System.nanoTime();
            long duration = end - start;

            SortingResult sortingResult = new SortingResult(numbers, duration);

            sortingResults.add(sortingResult);
        }

        return sortingResults;
    }
}
