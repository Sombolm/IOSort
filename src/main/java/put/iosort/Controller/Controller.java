package put.iosort.Controller;


import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import put.iosort.Service.Context;
import put.iosort.Service.Strategy.StrategyType;
import put.iosort.Config.Order;

import static put.iosort.Config.RestEndpoints.*;

@RestController
@RequestMapping(BASE)
@AllArgsConstructor
public class Controller {

    private final Context context;

    @GetMapping(value = GET + ARRAY + ORDER + STRATEGY_TYPE + ITERATIONS)
    public ResponseEntity<Object> getSortedArray(@RequestBody int[] numbers,
                                                 @PathVariable("order") Order order,
                                                 @PathVariable("strategyType") StrategyType strategyType,
                                                 @PathVariable("iterations") int iterations
    ) {
        return ResponseEntity.ok(context.handleContext(numbers, strategyType, order, iterations));
    }

    @GetMapping(value = GET + ARRAY + ORDER + STRATEGY_TYPE)
    public ResponseEntity<Object> getSortedArray(@RequestBody int[] numbers,
                                                 @PathVariable("order") Order order,
                                                 @PathVariable("strategyType") StrategyType strategyType
    ) {
        return ResponseEntity.ok(context.handleContext(numbers, strategyType, order));
    }




}
