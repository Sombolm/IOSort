package put.iosort.Controller;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import put.iosort.Controller.CustomValidator.CustomValidator;
import put.iosort.Entity.Input.InputDTO;
import put.iosort.Service.Context;
import put.iosort.Config.Order;

import static put.iosort.Config.RestEndpoints.*;

@RestController
@RequestMapping(BASE)
@AllArgsConstructor
@Validated
public class Controller {

    private final Context context;
    private final CustomValidator validator;
    @GetMapping(value = GET + ARRAY + ORDER  + ITERATIONS)
    public ResponseEntity<Object> getSortedArray(@RequestBody @NotEmpty @NotNull InputDTO input,
                                                 @PathVariable("order") Order order,
                                                 @PathVariable("iterations") int iterations
    ) {
        validator.validateEndpointInput(iterations, input.getNumbers(), input.getStrategyTypes());
        return ResponseEntity.ok(context.handleContext(input.getNumbers(),input.getStrategyTypes() , order, iterations));
    }

    @GetMapping(value = GET + ARRAY + ORDER)
    public ResponseEntity<Object> getSortedArray(@RequestBody @NotEmpty @NotNull InputDTO input,
                                                 @PathVariable("order") Order order
    ) {
        validator.validateEndpointInput(input.getNumbers(), input.getStrategyTypes());
        return ResponseEntity.ok(context.handleContext(input.getNumbers(),input.getStrategyTypes(), order));
    }
}
