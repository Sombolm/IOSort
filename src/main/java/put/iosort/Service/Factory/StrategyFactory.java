package put.iosort.Service.Factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import put.iosort.Service.Strategies.*;
import put.iosort.Service.Strategy.Strategy;
import put.iosort.Service.Strategy.StrategyType;

/**
 * The {@code StrategyFactory} class is a factory component responsible for creating instances of sorting strategies.
 * It provides a method to return the appropriate sorting strategy implementation based on the input {@link StrategyType}.
 *
 * <p>Purpose: Encapsulates the logic for selecting and instantiating specific sorting strategies, adhering to the Factory Design Pattern.</p>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@link #makeStrategy(StrategyType)}: Creates and returns an instance of the specified sorting strategy.</li>
 * </ul>
 *
 * <p>Supported Strategies:</p>
 * <ul>
 *     <li>{@code SELECTION}: Returns an instance of {@link SelectionSort}.</li>
 *     <li>{@code BUBBLE}: Returns an instance of {@link BubbleSort}.</li>
 *     <li>{@code INSERTION}: Returns an instance of {@link InsertionSort}.</li>
 *     <li>{@code COUNTING}: Returns an instance of {@link CountingSort}.</li>
 *     <li>{@code HEAP}: Returns an instance of {@link HeapSort}.</li>
 *     <li>{@code BOGO}: Returns an instance of {@link BogoSort}.</li>
 * </ul>
 *
 * <p>Usage:</p>
 * The factory is annotated with {@code @Component} to allow Spring to manage its lifecycle and dependency injection.
 *
 * @author caprimol
 * @version 1.0
 * @since 2024-12-15
 */

@Component
public class StrategyFactory {

    // Logger for this class
    /** Logger instance for logging factory operations. */
    private static final Logger logger = LoggerFactory.getLogger(StrategyFactory.class);

    /**
     * Creates and returns an instance of the sorting strategy specified by the {@link StrategyType}.
     *
     * <p>The method uses a {@code switch} statement to determine the appropriate strategy implementation.</p>
     *
     * <p>Supported strategies:</p>
     * <ul>
     *     <li>{@code SELECTION}: {@link SelectionSort}</li>
     *     <li>{@code BUBBLE}: {@link BubbleSort}</li>
     *     <li>{@code INSERTION}: {@link InsertionSort}</li>
     *     <li>{@code COUNTING}: {@link CountingSort}</li>
     *     <li>{@code HEAP}: {@link HeapSort}</li>
     *     <li>{@code BOGO}: {@link BogoSort}</li>
     * </ul>
     *
     * @param strategyType the {@link StrategyType} representing the desired sorting algorithm.
     * @return an instance of {@link Strategy} that implements the specified sorting algorithm.
     */
    public Strategy makeStrategy(StrategyType strategyType) {
        // Log the strategy type that is being created
        logger.info("Creating strategy for type: {}", strategyType);

        return switch (strategyType) {
            case SELECTION -> {
                logger.debug("Using SelectionSort strategy");
                yield new SelectionSort();
            }
            case BUBBLE -> {
                logger.debug("Using BubbleSort strategy");
                yield new BubbleSort();
            }
            case INSERTION -> {
                logger.debug("Using InsertionSort strategy");
                yield new InsertionSort();
            }
            case COUNTING -> {
                logger.debug("Using CountingSort strategy");
                yield new CountingSort();
            }
            case HEAP -> {
                logger.debug("Using HeapSort strategy");
                yield new HeapSort();
            }
            case BOGO -> {
                logger.debug("Using BogoSort strategy");
                yield new BogoSort();
            }
        };
    }
}
