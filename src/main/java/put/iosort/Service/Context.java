package put.iosort.Service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Entity.SortingResult.SortingResult;
import put.iosort.Entity.SortingResult.SortingResultFloat;
import put.iosort.Entity.SortingResult.SortingResultString;
import put.iosort.Service.Factory.StrategyFactory;
import put.iosort.Service.Strategy.Strategy;
import put.iosort.Service.Strategy.StrategyType;

import java.util.ArrayList;
import java.util.Arrays;
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
//@AllArgsConstructor
public class Context {

    private static final Logger logger = LoggerFactory.getLogger(Context.class);

    /**
     * Factory for creating sorting strategies.
     */
    private final StrategyFactory strategyFactory;

    public Context(StrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    //----------------FOR INT---------------------

    public List<SortingResult> handleContext(int[] numbers, StrategyType[] strategyTypes, Order order, int iterations) {
        List<SortingResult> sortingResults = new ArrayList<>();
        logger.info("Sorting process started for int array with {} strategies and {} iterations", strategyTypes.length, iterations);

        for (StrategyType strategyType : strategyTypes) {
            logger.debug("Applying strategy: {}", strategyType);

            Strategy strategy = strategyFactory.makeStrategy(strategyType);
            long start = System.nanoTime();

            int[] numbersResult = strategy.sort(Arrays.copyOf(numbers, numbers.length), order, iterations);
            long end = System.nanoTime();
            long duration = end - start;

            SortingResult sortingResult = new SortingResult(numbersResult, duration, strategyType);
            sortingResults.add(sortingResult);

            logger.debug("Strategy {} completed in {} nanoseconds", strategyType, duration);
        }

        logger.info("Sorting process completed for int array.");
        return sortingResults;
    }

    public List<SortingResult> handleContext(int[] numbers, StrategyType[] strategyTypes, Order order) {
        List<SortingResult> sortingResults = new ArrayList<>();
        logger.info("Sorting process started for int array with {} strategies", strategyTypes.length);

        for (StrategyType strategyType : strategyTypes) {
            logger.debug("Applying strategy: {}", strategyType);

            Strategy strategy = strategyFactory.makeStrategy(strategyType);
            long start = System.nanoTime();
            int[] numbersResult = strategy.sort(Arrays.copyOf(numbers, numbers.length), order);
            long end = System.nanoTime();
            long duration = end - start;

            SortingResult sortingResult = new SortingResult(numbersResult, duration, strategyType);
            sortingResults.add(sortingResult);

            logger.debug("Strategy {} completed in {} nanoseconds", strategyType, duration);
        }

        logger.info("Sorting process completed for int array.");
        return sortingResults;
    }

    //----------------FOR FLOAT---------------------

    public List<SortingResultFloat> handleContext(float[] numbers, StrategyType[] strategyTypes, Order order, int iterations) {
        List<SortingResultFloat> sortingResults = new ArrayList<>();
        logger.info("Sorting process started for float array with {} strategies and {} iterations", strategyTypes.length, iterations);

        for (StrategyType strategyType : strategyTypes) {
            logger.debug("Applying strategy: {}", strategyType);

            Strategy strategy = strategyFactory.makeStrategy(strategyType);
            long start = System.nanoTime();
            float[] numbersResult = strategy.sort(Arrays.copyOf(numbers, numbers.length), order, iterations);
            long end = System.nanoTime();
            long duration = end - start;

            SortingResultFloat sortingResult = new SortingResultFloat(numbersResult, duration, strategyType);
            sortingResults.add(sortingResult);

            logger.debug("Strategy {} completed in {} nanoseconds", strategyType, duration);
        }

        logger.info("Sorting process completed for float array.");
        return sortingResults;
    }

    public List<SortingResultFloat> handleContext(float[] numbers, StrategyType[] strategyTypes, Order order) {
        List<SortingResultFloat> sortingResults = new ArrayList<>();
        logger.info("Sorting process started for float array with {} strategies", strategyTypes.length);

        for (StrategyType strategyType : strategyTypes) {
            logger.debug("Applying strategy: {}", strategyType);

            Strategy strategy = strategyFactory.makeStrategy(strategyType);
            long start = System.nanoTime();
            float[] numbersResult = strategy.sort(Arrays.copyOf(numbers, numbers.length), order);
            long end = System.nanoTime();
            long duration = end - start;

            SortingResultFloat sortingResult = new SortingResultFloat(numbersResult, duration, strategyType);
            sortingResults.add(sortingResult);

            logger.debug("Strategy {} completed in {} nanoseconds", strategyType, duration);
        }

        logger.info("Sorting process completed for float array.");
        return sortingResults;
    }

    //----------------FOR STRING---------------------

    public List<SortingResultString> handleContext(String[] numbers, StrategyType[] strategyTypes, Order order) {
        List<SortingResultString> sortingResults = new ArrayList<>();
        logger.info("Sorting process started for string array with {} strategies", strategyTypes.length);

        for (StrategyType strategyType : strategyTypes) {
            logger.debug("Applying strategy: {}", strategyType);

            Strategy strategy = strategyFactory.makeStrategy(strategyType);
            long start = System.nanoTime();
            String[] numbersResult = strategy.sort(Arrays.copyOf(numbers, numbers.length), order);
            long end = System.nanoTime();
            long duration = end - start;

            SortingResultString sortingResult = new SortingResultString(numbersResult, duration, strategyType);
            sortingResults.add(sortingResult);

            logger.debug("Strategy {} completed in {} nanoseconds", strategyType, duration);
        }

        logger.info("Sorting process completed for string array.");
        return sortingResults;
    }

    //timelimit
    public List<SortingResult> handleContext(int[] numbers, StrategyType[] strategyTypes, Order order, int iterations, long timeLimitNano) {
        List<SortingResult> sortingResults = new ArrayList<>();
        logger.info("Sorting process started for int array with {} strategies, {} iterations, and time limit {} ms",
                strategyTypes.length, iterations, timeLimitNano);

        for (StrategyType strategyType : strategyTypes) {
            logger.debug("Applying strategy: {}", strategyType);

            Strategy strategy = strategyFactory.makeStrategy(strategyType);
            long start = System.nanoTime(); // Zmierz czas rozpoczęcia na poziomie strategii
            int[] numbersResult = strategy.sortWithTimeLimit(Arrays.copyOf(numbers, numbers.length), order, iterations, timeLimitNano);
            long end = System.nanoTime();   // Zmierz czas zakończenia
            long duration = (end - start);

            // Tworzenie wyniku
            SortingResult sortingResult = new SortingResult(numbersResult, duration, strategyType);
            sortingResults.add(sortingResult);

            logger.debug("Strategy {} completed in {} milliseconds", strategyType, duration);
        }

        logger.info("Sorting process completed for int array.");
        return sortingResults;
    }

    public List<SortingResultString> handleContext(String[] strings, StrategyType[] strategyTypes, Order order, int iterations, long timeLimitNano) {
        List<SortingResultString> sortingResults = new ArrayList<>();
        logger.info("Sorting process started for String array with {} strategies, {} iterations, and time limit {} ms",
                strategyTypes.length, iterations, timeLimitNano);

        for (StrategyType strategyType : strategyTypes) {
            logger.debug("Applying strategy: {}", strategyType);

            Strategy strategy = strategyFactory.makeStrategy(strategyType);
            long start = System.nanoTime();
            String[] stringsResult = strategy.sortWithTimeLimit(Arrays.copyOf(strings, strings.length), order, iterations, timeLimitNano);
            long end = System.nanoTime();
            long duration = (end - start);

            SortingResultString sortingResult = new SortingResultString(stringsResult, duration, strategyType);
            sortingResults.add(sortingResult);

            logger.debug("Strategy {} completed in {} milliseconds", strategyType, duration);
        }

        logger.info("Sorting process completed for String array.");
        return sortingResults;
    }

    public List<SortingResultFloat> handleContext(float[] numbers, StrategyType[] strategyTypes, Order order, int iterations, long timeLimitNano) {
        List<SortingResultFloat> sortingResults = new ArrayList<>();
        logger.info("Sorting process started for float array with {} strategies, {} iterations, and time limit {} ms",
                strategyTypes.length, iterations, timeLimitNano);

        for (StrategyType strategyType : strategyTypes) {
            logger.debug("Applying strategy: {}", strategyType);

            Strategy strategy = strategyFactory.makeStrategy(strategyType);
            long start = System.nanoTime();
            float[] numbersResult = strategy.sortWithTimeLimit(Arrays.copyOf(numbers, numbers.length), order, iterations, timeLimitNano);
            long end = System.nanoTime();
            long duration = (end - start);

            SortingResultFloat sortingResult = new SortingResultFloat(numbersResult, duration, strategyType);
            sortingResults.add(sortingResult);

            logger.debug("Strategy {} completed in {} milliseconds", strategyType, duration);
        }

        logger.info("Sorting process completed for float array.");
        return sortingResults;
    }


}
