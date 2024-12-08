package put.iosort.Entity.Input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import put.iosort.Service.Strategy.StrategyType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InputDTO {

    @NotEmpty
    int @NotNull [] numbers;

    StrategyType [] strategyTypes;

}
