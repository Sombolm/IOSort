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

/**
 * The {@code Context} class acts as a service layer responsible for orchestrating
 * the sorting of arrays based on the provided strategies and orders.
 * It delegates sorting tasks to appropriate {@link Strategy} implementations
 * created by the {@link StrategyFactory}.
 * <p>
 * This class provides two overloads of the {@code handleContext} method:
 * <ul>
 *     <li> One for sorting with a specified number of iterations.
 *     <li> Another for sorting without iterations.
 * </ul>
 * <p>
 * The sorting results, including the sorted array and the duration of the sorting process,
 * are encapsulated in a {@link SortingResult} and returned as a list.
 * </p>
 *
 * <p><b>Usage:</b></p>
 * <pre>
 *     Context context = new Context(strategyFactory);
 *     List&lt;SortingResult&gt; results = context.handleContext(numbers, strategyTypes, Order.ASC, 10);
 * </pre>
 *
 * @author caprimol
 * @version 1.0
 * @since 2024-12-15
 */

@Service
@AllArgsConstructor
public class Context {

    /**
     * Factory for creating sorting strategies.
     */
    private final StrategyFactory strategyFactory;

    /**
     * Handles the sorting of the given array of numbers using the specified strategy types, order, and iterations.
     * <p>
     * Each strategy is executed sequentially, and the sorted results are measured for performance
     * (time taken in nanoseconds). The results for each strategy are encapsulated in
     * {@link SortingResult} objects.
     * </p>
     *
     * @param numbers       the array of integers to be sorted
     * @param strategyTypes the array of strategy types defining the sorting algorithms to use
     * @param order         the order (ascending or descending) in which to sort the numbers
     * @param iterations    the number of iterations for the sorting algorithm to perform
     * @return a list of {@link SortingResult} objects, each containing the sorted array and the duration of the sorting
     */

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

    /**
     * Handles the sorting of the given array of numbers using the specified strategy types and order.
     * <p>
     * Each strategy is executed sequentially, and the sorted results are measured for performance
     * (time taken in nanoseconds). The results for each strategy are encapsulated in
     * {@link SortingResult} objects.
     * </p>
     *
     * @param numbers       the array of integers to be sorted
     * @param strategyTypes the array of strategy types defining the sorting algorithms to use
     * @param order         the order (ascending or descending) in which to sort the numbers
     * @return a list of {@link SortingResult} objects, each containing the sorted array and the duration of the sorting
     */

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
