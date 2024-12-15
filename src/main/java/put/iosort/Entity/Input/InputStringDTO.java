package put.iosort.Entity.Input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import put.iosort.Service.Strategy.StrategyType;

/**
 * Input structure for strings.
 * @author caprimol
 * @version 1.0
 * @since 2024-12-15
 */

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class InputStringDTO {
//
//    @NotEmpty
//    String @NotNull [] numbers;
//
//    StrategyType [] strategyTypes;
//
//}
public class InputStringDTO {

    //@NotEmpty
    public String [] numbers;
    public StrategyType [] strategyTypes;

    public InputStringDTO(String [] numbers, StrategyType [] strategyTypes){
        this.numbers = numbers;
        this.strategyTypes = strategyTypes;
    }

    public String[] getNumbers() {
        return numbers;
    }

    public StrategyType[] getStrategyTypes() {
        return strategyTypes;
    }

}