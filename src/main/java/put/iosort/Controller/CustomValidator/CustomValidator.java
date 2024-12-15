package put.iosort.Controller.CustomValidator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

    public CustomValidator(){}

    public void validateEndpointInput(int iterations, int[] array, StrategyType [] strategyTypes) {
        if (iterations < 0) {
            throw new IllegalArgumentException(INVALID_ITERATIONS);
        }
        if (array.length == 0) {
            throw new IllegalArgumentException(INVALID_ARRAY);
        }
        if (strategyTypes.length == 0) {
            throw new IllegalArgumentException(INVALID_STRATEGIES);
        }
    }

    public void validateEndpointInput(int[] array, StrategyType [] strategyTypes) {
        if (array.length == 0) {
            throw new IllegalArgumentException(INVALID_ARRAY);
        }
        if (strategyTypes.length == 0) {
            throw new IllegalArgumentException(INVALID_STRATEGIES);
        }
    }

}
