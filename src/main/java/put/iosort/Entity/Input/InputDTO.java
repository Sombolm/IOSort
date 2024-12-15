package put.iosort.Entity.Input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import put.iosort.Service.Strategy.StrategyType;

/**
 * Input structure for integers.
 * @author caprimol
 * @version 1.0
 * @since 2024-12-15
 */

//@AllArgsConstructor
//@Data
public class InputDTO {

    //@NotEmpty
    public int [] numbers;
    public StrategyType [] strategyTypes;

    public InputDTO(int [] numbers, StrategyType [] strategyTypes){
        this.numbers = numbers;
        this.strategyTypes = strategyTypes;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public StrategyType[] getStrategyTypes() {
        return strategyTypes;
    }

}
