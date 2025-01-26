package put.iosort.Entity.Input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import put.iosort.Service.Strategy.StrategyType;

/**
 * Input structure for floats.
 * @author caprimol
 * @version 1.0
 * @since 2024-12-15
 */

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class InputFloatDTO {
//
//    @NotEmpty
//    float @NotNull [] numbers;
//
//    StrategyType [] strategyTypes;
//
//}
public class InputFloatDTO {

    //@NotEmpty
    public float [] numbers;
    public StrategyType [] strategyTypes;

    public InputFloatDTO(float [] numbers, StrategyType [] strategyTypes){
        this.numbers = numbers;
        this.strategyTypes = strategyTypes;
    }

    public float[] getNumbers() {
        return numbers;
    }

    public StrategyType[] getStrategyTypes() {
        return strategyTypes;
    }

    public void setNumbers(float[] floats) {
        this.numbers = floats;
    }
}