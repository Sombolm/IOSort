package put.iosort.Controller;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import put.iosort.Controller.CustomValidator.CustomValidator;
import put.iosort.Entity.Input.InputDTO;
import put.iosort.Entity.Input.InputFloatDTO;
import put.iosort.Entity.Input.InputStringDTO;
import put.iosort.Service.Context;
import put.iosort.Config.Order;

import static put.iosort.Config.RestEndpoints.*;

/**
 * The {@code Controller} class is a REST controller that handles API requests for sorting operations.
 * It provides endpoints for sorting arrays based on specified strategies, order, and iterations.
 *
 * <p>Purpose: Acts as the entry point for client requests, performing input validation and delegating tasks to the service layer.</p>
 *
 * <p>Endpoints:</p>
 * <ul>
 *     <li>{@code GET /IOS/api/get/array/{order}/{iterations}}:
 *         Handles requests to sort an array with a specific order and a number of iterations.
 *     </li>
 *     <li>{@code GET /IOS/api/get/array/{order}}:
 *         Handles requests to sort an array with a specific order without specifying iterations.
 *     </li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@link #getSortedArray(InputDTO, Order, int)}: Sorts an array with specified order and iterations.</li>
 *     <li>{@link #getSortedArray(InputDTO, Order)}: Sorts an array with specified order.</li>
 * </ul>
 *
 * <p>Validation:</p>
 * <ul>
 *     <li>Input validation is performed using {@link CustomValidator} before delegating tasks to {@link Context}.
 * </ul>
 *
 * <p>Returns:</p>
 * <ul>
 *     <li>{@link ResponseEntity}: Encapsulates the result of the sorting operation.</li>
 * </ul>
 *
 * @author caprimol
 * @version 1.0
 * @since 2024-12-15
 */

@RestController
@RequestMapping(BASE)
@AllArgsConstructor
@Validated
public class Controller {

    //Injectuje (czyli wstrzykuje, dodaje do klasy) obiekty klasy Context oraz CustomValidator
    private final Context context;
    private final CustomValidator validator;

    /**
     * Handles HTTP GET requests for sorting an array with a specified order and a limited number of iterations.
     *
     * @param input     the {@link InputDTO} containing the array to be sorted and sorting strategies.
     * @param order     the {@link Order} specifying whether the sorting should be ascending or descending.
     * @param iterations the maximum number of iterations allowed for the sorting process.
     * @return a {@link ResponseEntity} containing the sorted array and performance metrics.
     * @throws IllegalArgumentException if the input array is empty, strategies are not specified, or iterations are invalid.
     */

    @GetMapping(value = GET + ARRAY + ORDER + ITERATIONS)
    public ResponseEntity<Object> getSortedArray(@RequestBody @NotNull InputDTO input,
                                                 @PathVariable("order") Order order,
                                                 @PathVariable("iterations") int iterations
    ) {
        validator.validateEndpointInput(iterations, input.getNumbers(), input.getStrategyTypes());
        return ResponseEntity.ok(context.handleContext(input.getNumbers(),input.getStrategyTypes() , order, iterations));
    }

    @GetMapping(value = GET + ARRAY + FLOAT + ORDER + ITERATIONS)
    public ResponseEntity<Object> getSortedArray(@RequestBody @NotNull InputFloatDTO input,
                                                 @PathVariable("order") Order order,
                                                 @PathVariable("iterations") int iterations
    ) {
        validator.validateEndpointInput(iterations, input.getNumbers(), input.getStrategyTypes());
        return ResponseEntity.ok(context.handleContext(input.getNumbers(),input.getStrategyTypes() , order, iterations));
    }

    @GetMapping(value = GET + ARRAY + STRING + ORDER + ITERATIONS)
    public ResponseEntity<Object> getSortedArray(@RequestBody @NotNull InputStringDTO input,
                                                 @PathVariable("order") Order order,
                                                 @PathVariable("iterations") int iterations
    ) {
        validator.validateEndpointInput(iterations, input.getNumbers(), input.getStrategyTypes());
        return ResponseEntity.ok(context.handleContext(input.getNumbers(),input.getStrategyTypes() , order, iterations));
    }

    @GetMapping(value = GET + ARRAY + ORDER)
    public ResponseEntity<Object> getSortedArray(@RequestBody @NotNull InputDTO input,
                                                 @PathVariable("order") Order order
    ) {
        validator.validateEndpointInput(input.getNumbers(), input.getStrategyTypes());
        return ResponseEntity.ok(context.handleContext(input.getNumbers(),input.getStrategyTypes(), order));
    }

    @GetMapping(value = GET + ARRAY + FLOAT + ORDER)
    public ResponseEntity<Object> getSortedArray(@RequestBody @NotNull InputFloatDTO input,
                                                 @PathVariable("order") Order order
    ) {
        validator.validateEndpointInput(input.getNumbers(), input.getStrategyTypes());
        return ResponseEntity.ok(context.handleContext(input.getNumbers(),input.getStrategyTypes(), order));
    }

    @GetMapping(value = GET + ARRAY + STRING + ORDER)
    public ResponseEntity<Object> getSortedArray(@RequestBody @NotNull InputStringDTO input,
                                                 @PathVariable("order") Order order
    ) {
        validator.validateEndpointInput(input.getNumbers(), input.getStrategyTypes());
        return ResponseEntity.ok(context.handleContext(input.getNumbers(),input.getStrategyTypes(), order));
    }
}
