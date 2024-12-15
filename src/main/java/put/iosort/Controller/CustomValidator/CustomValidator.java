package put.iosort.Controller.CustomValidator;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import put.iosort.Service.Strategy.StrategyType;

import static put.iosort.Config.ErrorMessages.*;


@Service
@NoArgsConstructor
public class CustomValidator {
    public void validateEndpointInput(int iterations, int[] array, StrategyType [] strategyTypes) {
        if (iterations < 0) {
            throw new IllegalArgumentException(INVALID_ITERATIONS);
        }
        if (array.length == 0) {
            throw new IllegalArgumentException(INVALID_ARRAY);
        }
        if (strategyTypes.length == 0 || strategyTypes.length > 6) {
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
