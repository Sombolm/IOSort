package put.iosort.Entity.Input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import put.iosort.Service.Strategy.StrategyType;

/**
 * Input structure.
 * @author caprimol
 * @version 1.0
 * @since 2024-12-15
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InputDTO {

    @NotEmpty
    int @NotNull [] numbers;

    StrategyType [] strategyTypes;

}
