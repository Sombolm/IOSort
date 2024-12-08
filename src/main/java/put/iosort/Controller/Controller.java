package put.iosort.Controller;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import put.iosort.Exception.CustomExceptions.InvalidIterationsException;
import put.iosort.Service.Context;
import put.iosort.Service.Strategy.StrategyType;
import put.iosort.Config.Order;

import static put.iosort.Config.ErrorMessages.INVALID_ITERATIONS;
import static put.iosort.Config.RestEndpoints.*;

@RestController
@RequestMapping(BASE)
@AllArgsConstructor
@Validated
public class Controller {

    private final Context context;
    @GetMapping(value = GET + ARRAY + ORDER + STRATEGY_TYPE + ITERATIONS)
    public ResponseEntity<Object> getSortedArray(@RequestBody @NotEmpty int @NotNull [] numbers,
                                                 @PathVariable("order") Order order,
                                                 @PathVariable("strategyType") StrategyType strategyType,
                                                 @PathVariable("iterations") int iterations
    ) {
        if (iterations <= -1) {
            throw new InvalidIterationsException(INVALID_ITERATIONS);
        }
        return ResponseEntity.ok(context.handleContext(numbers, strategyType, order, iterations));
    }

    @GetMapping(value = GET + ARRAY + ORDER + STRATEGY_TYPE)
    public ResponseEntity<Object> getSortedArray(@RequestBody @NotEmpty int @NotNull [] numbers,
                                                 @PathVariable("order") Order order,
                                                 @PathVariable("strategyType") StrategyType[] strategyTypes
    ) {
        return ResponseEntity.ok(context.handleContext(numbers, strategyTypes, order));
    }
}
