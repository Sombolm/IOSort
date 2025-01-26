package put.iosort.Controller;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import put.iosort.Controller.CustomValidator.CustomValidator;
import put.iosort.Controller.DataGenerator.DataGenerator;
import put.iosort.Entity.Input.InputDTO;
import put.iosort.Entity.Input.InputFloatDTO;
import put.iosort.Entity.Input.InputStringDTO;
import put.iosort.Service.Context;
import put.iosort.Config.Order;

import static put.iosort.Config.RestEndpoints.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Optional;

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
 *      <li>{@link #getSortedArray(InputDTO, Order, int,Optional)}:
 *           Sorts an array (of integers) with a specified order and a maximum number of iterations.
 *           Mapped to: {@code GET /IOS/api/get/array/{order}/{iterations}}
 *       </li>
 *       <li>{@link #getSortedArray(InputFloatDTO, Order, int,Optional)}:
 *           Sorts an array (of floats) with a specified order and a maximum number of iterations.
 *           Mapped to: {@code GET /IOS/api/get/array/float/{order}/{iterations}}
 *       </li>
 *       <li>{@link #getSortedArray(InputStringDTO, Order, int,Optional)}:
 *           Sorts an array (of strings) with a specified order and a maximum number of iterations.
 *           Mapped to: {@code GET /IOS/api/get/array/string/{order}/{iterations}}
 *       </li>
 *       <li>{@link #getSortedArray(InputDTO, Order,Optional)}:
 *           Sorts an array (of integers) with a specified order without a limit on iterations.
 *           Mapped to: {@code GET /IOS/api/get/array/{order}}
 *       </li>
 *       <li>{@link #getSortedArray(InputFloatDTO, Order,Optional)}:
 *           Sorts an array (of floats) with a specified order without a limit on iterations.
 *           Mapped to: {@code GET /IOS/api/get/array/float/{order}}
 *       </li>
 *       <li>{@link #getSortedArray(InputStringDTO, Order,Optional)}:
 *           Sorts an array (of strings) with a specified order without a limit on iterations.
 *           Mapped to: {@code GET /IOS/api/get/array/string/{order}}
 *       </li>
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
@Validated
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    //Injectuje (czyli wstrzykuje, dodaje do klasy) obiekty klasy Context oraz CustomValidator
    private final Context context;
    private final CustomValidator validator;
    private final DataGenerator dataGenerator;

    public Controller(Context context, CustomValidator validator, DataGenerator dataGenerator) {
        this.context = context;
        this.validator = validator;
        this.dataGenerator = dataGenerator;
    }

    /**
     * Handles HTTP GET requests for sorting an array with a specified order and a limited number of iterations.
     *
     * @param input      the {@link InputDTO} containing the array to be sorted and sorting strategies.
     * @param order      the {@link Order} specifying whether the sorting should be ascending or descending.
     * @param iterations the maximum number of iterations allowed for the sorting process.
     * @return a {@link ResponseEntity} containing the sorted array and performance metrics.
     * @throws IllegalArgumentException if the input array is empty, strategies are not specified, or iterations are invalid.
     */

    @GetMapping(value = GET + ARRAY + ORDER + ITERATIONS)
    public ResponseEntity<Object> getSortedArray(@RequestBody InputDTO input,
                                                 @PathVariable("order") Order order,
                                                 @PathVariable("iterations") int iterations,
                                                 @RequestParam("generateData") Optional<Boolean> generateData) {

        logger.info("Received request for sorting an integer array with order {} and iterations {}", order, iterations);
        logger.debug("Input array: {}, Sorting strategies: {}", input.getNumbers(), input.getStrategyTypes());

        if (generateData.isPresent() && generateData.get()) {
            logger.info("Generating random data for input array.");
            input.setNumbers(dataGenerator.generateRandomIntArray());
        }
        validator.validateEndpointInput(iterations, input.getNumbers(), input.getStrategyTypes());

        ResponseEntity<Object> response = ResponseEntity.ok(context.handleContext(input.getNumbers(), input.getStrategyTypes(), order, iterations));
        logger.info("Sorting completed successfully.");
        return response;
    }

    @GetMapping(value = GET + ARRAY + FLOAT + ORDER + ITERATIONS)
    public ResponseEntity<Object> getSortedArray(@RequestBody InputFloatDTO input,
                                                 @PathVariable("order") Order order,
                                                 @PathVariable("iterations") int iterations,
                                                 @RequestParam("generateData") Optional<Boolean> generateData) {
        logger.info("Received request for sorting a float array with order {} and iterations {}", order, iterations);
        logger.debug("Input array: {}, Sorting strategies: {}", input.getNumbers(), input.getStrategyTypes());

        if (generateData.isPresent() && generateData.get()) {
            logger.info("Generating random data for input array.");
            input.setNumbers(dataGenerator.generateRandomFloatArray());
        }

        validator.validateEndpointInput(iterations, input.getNumbers(), input.getStrategyTypes());
        ResponseEntity<Object> response = ResponseEntity.ok(context.handleContext(input.getNumbers(), input.getStrategyTypes(), order, iterations));
        logger.info("Sorting completed successfully.");
        return response;
    }

    @GetMapping(value = GET + ARRAY + STRING + ORDER + ITERATIONS)
    public ResponseEntity<Object> getSortedArray(@RequestBody InputStringDTO input,
                                                 @PathVariable("order") Order order,
                                                 @PathVariable("iterations") int iterations,
                                                 @RequestParam("generateData") Optional<Boolean> generateData) {
        logger.info("Received request for sorting a string array with order {} and iterations {}", order, iterations);
        logger.debug("Input array: {}, Sorting strategies: {}", input.getNumbers(), input.getStrategyTypes());

        if (generateData.isPresent() && generateData.get()) {
            logger.info("Generating random data for input array.");
            input.setNumbers(dataGenerator.generateRandomStringArray());
        }

        validator.validateEndpointInput(iterations, input.getNumbers(), input.getStrategyTypes());
        ResponseEntity<Object> response = ResponseEntity.ok(context.handleContext(input.getNumbers(), input.getStrategyTypes(), order));
        logger.info("Sorting completed successfully.");
        return response;
    }



    /**
     * Handles HTTP GET requests for sorting an array with a specified order without a limit on iterations.
     *
     * @param input the {@link InputDTO} containing the array to be sorted and sorting strategies.
     * @param order the {@link Order} specifying whether the sorting should be ascending or descending.
     * @return a {@link ResponseEntity} containing the sorted array and performance metrics.
     * @throws IllegalArgumentException if the input array is empty or strategies are not specified.
     */
    @GetMapping(value = GET + ARRAY + ORDER)
    public ResponseEntity<Object> getSortedArray(@RequestBody InputDTO input,
                                                 @PathVariable("order") Order order,
                                                 @RequestParam("generateData") Optional<Boolean> generateData) {
        logger.info("Received request for sorting an integer array with order {}", order);
        logger.debug("Input array: {}, Sorting strategies: {}", input.getNumbers(), input.getStrategyTypes());

        if (generateData.isPresent() && generateData.get()) {
            logger.info("Generating random data for input array.");
            input.setNumbers(dataGenerator.generateRandomIntArray());
        }

        validator.validateEndpointInput(input.getNumbers(), input.getStrategyTypes());
        ResponseEntity<Object> response = ResponseEntity.ok(context.handleContext(input.getNumbers(), input.getStrategyTypes(), order));
        logger.info("Sorting completed successfully.");
        return response;
    }

    @GetMapping(value = GET + ARRAY + FLOAT + ORDER)
    public ResponseEntity<Object> getSortedArray(@RequestBody InputFloatDTO input,
                                                 @PathVariable("order") Order order,
                                                 @RequestParam("generateData") Optional<Boolean> generateData) {
        logger.info("Received request for sorting a float array with order {}", order);
        logger.debug("Input array: {}, Sorting strategies: {}", input.getNumbers(), input.getStrategyTypes());

        if (generateData.isPresent() && generateData.get()) {
            logger.info("Generating random data for input array.");
            input.setNumbers(dataGenerator.generateRandomFloatArray());
        }

        validator.validateEndpointInput(input.getNumbers(), input.getStrategyTypes());
        ResponseEntity<Object> response = ResponseEntity.ok(context.handleContext(input.getNumbers(), input.getStrategyTypes(), order));
        logger.info("Sorting completed successfully.");
        return response;
    }

    @GetMapping(value = GET + ARRAY + STRING + ORDER)
    public ResponseEntity<Object> getSortedArray(@RequestBody InputStringDTO input,
                                                 @PathVariable("order") Order order,
                                                 @RequestParam("generateData") Optional<Boolean> generateData) {
        logger.info("Received request for sorting a string array with order {}", order);
        logger.debug("Input array: {}, Sorting strategies: {}", input.getNumbers(), input.getStrategyTypes());

        if (generateData.isPresent() && generateData.get()) {
            logger.info("Generating random data for input array.");
            input.setNumbers(dataGenerator.generateRandomStringArray());
        }

        validator.validateEndpointInput(input.getNumbers(), input.getStrategyTypes());
        ResponseEntity<Object> response = ResponseEntity.ok(context.handleContext(input.getNumbers(), input.getStrategyTypes(), order));
        logger.info("Sorting completed successfully.");
        return response;
    }

    //timelimit
    @GetMapping(value = GET + ARRAY + ORDER + ITERATIONS+ "/TIMELIMIT")
    public ResponseEntity<Object> getSortedArray(@RequestBody InputDTO input,
                                                 @PathVariable("order") Order order,
                                                 @PathVariable("iterations") int iterations,
                                                 @RequestParam("timeLimit") Optional<Long> timeLimit,
                                                 @RequestParam("generateData") Optional<Boolean> generateData) {

        logger.info("Received request for sorting an integer array with order {}, iterations {}, and time limit {} ms",
                order, iterations, timeLimit.orElse(-1L));

        if (generateData.isPresent() && generateData.get()) {
            logger.info("Generating random data for input array.");
            input.setNumbers(dataGenerator.generateRandomIntArray());
        }
        validator.validateEndpointInput(iterations, input.getNumbers(), input.getStrategyTypes());

        long timeLimitNano = timeLimit.orElse(-1L);
        ResponseEntity<Object> response = ResponseEntity.ok(context.handleContext(input.getNumbers(),
                input.getStrategyTypes(), order, iterations, timeLimitNano));
        logger.info("Sorting completed successfully.");
        return response;
    }

    @GetMapping(value = GET + ARRAY + STRING + ORDER + ITERATIONS+ "/TIMELIMIT")
    public ResponseEntity<Object> getSortedArray(@RequestBody InputStringDTO input,
                                                       @PathVariable("order") Order order,
                                                       @PathVariable("iterations") int iterations,
                                                       @RequestParam("timeLimit") Optional<Long> timeLimit,
                                                       @RequestParam("generateData") Optional<Boolean> generateData) {

        logger.info("Received request for sorting a string array with order {}, iterations {}, and time limit {} ms",
                order, iterations, timeLimit.orElse(-1L));

        if (generateData.isPresent() && generateData.get()) {
            logger.info("Generating random data for input array.");
            input.setNumbers(dataGenerator.generateRandomStringArray());
        }
        validator.validateEndpointInput(iterations, input.getNumbers(), input.getStrategyTypes());

        long timeLimitNano = timeLimit.orElse(-1L);
        ResponseEntity<Object> response = ResponseEntity.ok(context.handleContext(input.getNumbers(),
                input.getStrategyTypes(), order, iterations, timeLimitNano));
        logger.info("Sorting completed successfully.");
        return response;
    }

    @GetMapping(value = GET + ARRAY + FLOAT + ORDER + ITERATIONS+ "/TIMELIMIT")
    public ResponseEntity<Object> getSortedArray(@RequestBody InputFloatDTO input,
                                                      @PathVariable("order") Order order,
                                                      @PathVariable("iterations") int iterations,
                                                      @RequestParam("timeLimit") Optional<Long> timeLimit,
                                                      @RequestParam("generateData") Optional<Boolean> generateData) {

        logger.info("Received request for sorting a float array with order {}, iterations {}, and time limit {} ms",
                order, iterations, timeLimit.orElse(-1L));

        if (generateData.isPresent() && generateData.get()) {
            logger.info("Generating random data for input array.");
            input.setNumbers(dataGenerator.generateRandomFloatArray());
        }
        validator.validateEndpointInput(iterations, input.getNumbers(), input.getStrategyTypes());

        long timeLimitNano = timeLimit.orElse(-1L);
        ResponseEntity<Object> response = ResponseEntity.ok(context.handleContext(input.getNumbers(),
                input.getStrategyTypes(), order, iterations, timeLimitNano));
        logger.info("Sorting completed successfully.");
        return response;
    }

}
