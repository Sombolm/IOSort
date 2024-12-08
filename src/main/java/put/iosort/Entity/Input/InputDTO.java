package put.iosort.Entity.Input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import put.iosort.Service.Strategy.StrategyType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InputDTO {

    int[] numbers;
    StrategyType[] strategyTypes;

}
