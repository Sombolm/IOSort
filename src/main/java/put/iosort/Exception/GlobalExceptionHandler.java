package put.iosort.Exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import put.iosort.Exception.CustomExceptions.InvalidIterationsException;

import static put.iosort.Config.ErrorMessages.*;

/**
 * The {@code GlobalExceptionHandler} class is a centralized exception handler for the application.
 * It uses Spring's {@link ControllerAdvice} to catch and handle exceptions thrown by controllers globally.
 *
 * <p>Purpose: Simplifies exception management by mapping specific exceptions to user-friendly responses.</p>
 *
 * <p>Handlers:</p>
 * <ul>
 *     <li>{@link MethodArgumentTypeMismatchException}, {@link IllegalArgumentException}: Handles invalid path variables or arguments.</li>
 *     <li>{@link InvalidIterationsException}: Handles exceptions where the iteration value is invalid.</li>
 *     <li>{@link ConstraintViolationException}: Handles validation errors for request bodies or parameters.</li>
 * </ul>
 *
 * <p>Response:</p>
 * All handlers return a {@link ResponseEntity} with an appropriate error message and HTTP status code.
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@link #handlePathVariableMismatch(Exception)}: Returns a {@code 400 BAD_REQUEST} for invalid path variables or arguments.</li>
 *     <li>{@link #handleInvalidIterations(InvalidIterationsException)}: Returns a {@code 400 BAD_REQUEST} for invalid iteration counts.</li>
 *     <li>{@link #handleConstraintViolation(ConstraintViolationException)}: Returns a {@code 400 BAD_REQUEST} for request body validation failures.</li>
 * </ul>
 *
 * @author caprimol
 * @version 1.0
 * @since 2024-12-15
 */

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({ MethodArgumentTypeMismatchException.class, IllegalArgumentException.class })
    public ResponseEntity<Object> handlePathVariableMismatch(Exception ex) {
        String errorMessage = INVALID_PATH_VARIABLE + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidIterationsException.class)
    public ResponseEntity<Object> handleInvalidIterations(InvalidIterationsException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        String errorMessage = REQUEST_BODY_VALIDATION_FAILED + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
