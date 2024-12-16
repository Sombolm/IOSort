package put.iosort.Controller.CustomValidator;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import put.iosort.Service.Strategy.StrategyType;

import static put.iosort.Config.ErrorMessages.*;

/**
 * The {@code CustomValidator} class is a utility service for validating endpoint inputs.
 * It ensures that all necessary parameters meet the required conditions before processing.
 *
 * <p>Purpose: Provides validation methods to enforce input constraints for REST API endpoints.</p>
 *
 * <p>Validation Rules:</p>
 * <ul>
 *     <li>{@code iterations}: Must be greater than or equal to 0.</li>
 *     <li>{@code array}: Cannot be empty.</li>
 *     <li>{@code strategyTypes}: Must contain up to six valid strategies.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@link #validateEndpointInput(int, int[], StrategyType[])}: Validates input with iterations, array, and strategy types.</li>
 *     <li>{@link #validateEndpointInput(int[], StrategyType[])}: Validates input with array and strategy types.</li>
 * </ul>
 *
 * <p>Throws:</p>
 * <ul>
 *     <li>{@link IllegalArgumentException}: If any validation rule is violated, with a descriptive error message.</li>
 * </ul>
 *
 * @author caprimol
 * @version 1.0
 * @since 2024-12-15
 */

@Service
//@NoArgsConstructor
public class CustomValidator {

    // Logger instance
    private static final Logger logger = LoggerFactory.getLogger(CustomValidator.class);

    public CustomValidator(){}

    public void validateEndpointInput(int iterations, int[] array, StrategyType[] strategyTypes) {
        logger.info("Validating input: iterations = {}, array length = {}, strategy types count = {}", iterations, array.length, strategyTypes.length);

        if (iterations < 0) {
            logger.error("Validation failed: {} (iterations cannot be negative)", INVALID_ITERATIONS);
            throw new IllegalArgumentException(INVALID_ITERATIONS);
        }
        if (array.length == 0) {
            logger.error("Validation failed: {} (array cannot be empty)", INVALID_ARRAY);
            throw new IllegalArgumentException(INVALID_ARRAY);
        }
        if (strategyTypes.length == 0 || strategyTypes.length > 6) {
            logger.error("Validation failed: {} (strategy types count must be between 1 and 6)", INVALID_STRATEGIES);
            throw new IllegalArgumentException(INVALID_STRATEGIES);
        }

        logger.info("Validation passed for int array input.");
    }

    public void validateEndpointInput(int iterations, float[] array, StrategyType[] strategyTypes) {
        logger.info("Validating input: iterations = {}, array length = {}, strategy types count = {}", iterations, array.length, strategyTypes.length);

        if (iterations < 0) {
            logger.error("Validation failed: {} (iterations cannot be negative)", INVALID_ITERATIONS);
            throw new IllegalArgumentException(INVALID_ITERATIONS);
        }
        if (array.length == 0) {
            logger.error("Validation failed: {} (array cannot be empty)", INVALID_ARRAY);
            throw new IllegalArgumentException(INVALID_ARRAY);
        }
        if (strategyTypes.length == 0 || strategyTypes.length > 6) {
            logger.error("Validation failed: {} (strategy types count must be between 1 and 6)", INVALID_STRATEGIES);
            throw new IllegalArgumentException(INVALID_STRATEGIES);
        }

        logger.info("Validation passed for float array input.");
    }

    public void validateEndpointInput(int iterations, String[] array, StrategyType[] strategyTypes) {
        logger.info("Validating input: iterations = {}, array length = {}, strategy types count = {}", iterations, array.length, strategyTypes.length);

        if (iterations < 0) {
            logger.error("Validation failed: {} (iterations cannot be negative)", INVALID_ITERATIONS);
            throw new IllegalArgumentException(INVALID_ITERATIONS);
        }
        if (array.length == 0) {
            logger.error("Validation failed: {} (array cannot be empty)", INVALID_ARRAY);
            throw new IllegalArgumentException(INVALID_ARRAY);
        }
        if (strategyTypes.length == 0 || strategyTypes.length > 6) {
            logger.error("Validation failed: {} (strategy types count must be between 1 and 6)", INVALID_STRATEGIES);
            throw new IllegalArgumentException(INVALID_STRATEGIES);
        }

        logger.info("Validation passed for String array input.");
    }

    public void validateEndpointInput(int[] array, StrategyType[] strategyTypes) {
        logger.info("Validating input: array length = {}, strategy types count = {}", array.length, strategyTypes.length);

        if (array.length == 0) {
            logger.error("Validation failed: {} (array cannot be empty)", INVALID_ARRAY);
            throw new IllegalArgumentException(INVALID_ARRAY);
        }
        if (strategyTypes.length == 0) {
            logger.error("Validation failed: {} (at least one strategy type is required)", INVALID_STRATEGIES);
            throw new IllegalArgumentException(INVALID_STRATEGIES);
        }

        logger.info("Validation passed for int array input.");
    }

    public void validateEndpointInput(float[] array, StrategyType[] strategyTypes) {
        logger.info("Validating input: array length = {}, strategy types count = {}", array.length, strategyTypes.length);

        if (array.length == 0) {
            logger.error("Validation failed: {} (array cannot be empty)", INVALID_ARRAY);
            throw new IllegalArgumentException(INVALID_ARRAY);
        }
        if (strategyTypes.length == 0) {
            logger.error("Validation failed: {} (at least one strategy type is required)", INVALID_STRATEGIES);
            throw new IllegalArgumentException(INVALID_STRATEGIES);
        }

        logger.info("Validation passed for float array input.");
    }

    public void validateEndpointInput(String[] array, StrategyType[] strategyTypes) {
        logger.info("Validating input: array length = {}, strategy types count = {}", array.length, strategyTypes.length);

        if (array.length == 0) {
            logger.error("Validation failed: {} (array cannot be empty)", INVALID_ARRAY);
            throw new IllegalArgumentException(INVALID_ARRAY);
        }
        if (strategyTypes.length == 0) {
            logger.error("Validation failed: {} (at least one strategy type is required)", INVALID_STRATEGIES);
            throw new IllegalArgumentException(INVALID_STRATEGIES);
        }

        logger.info("Validation passed for String array input.");
    }
}
