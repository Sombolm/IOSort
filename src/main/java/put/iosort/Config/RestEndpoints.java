package put.iosort.Config;

/**
 * The {@code RestEndpoints} class provides constants representing the paths to various REST API endpoints
 * used in the application. These constants define the base path and specific sub-paths for accessing
 * sorting-related functionalities.
 *
 * <p>Purpose:</p>
 * <ul>
 *     <li>Centralizes endpoint path definitions to ensure consistency across the application.</li>
 *     <li>Simplifies the maintenance and modification of endpoint paths.</li>
 * </ul>
 *
 * <p>Endpoint Constants:</p>
 * <ul>
 *     <li>{@code BASE}: The base path for the REST API.</li>
 *     <li>{@code GET}: Sub-path for HTTP GET requests.</li>
 *     <li>{@code ARRAY}: Sub-path for operations related to array sorting.</li>
 *     <li>{@code FLOAT}: Sub-path for operations involving float arrays.</li>
 *     <li>{@code STRING}: Sub-path for operations involving string arrays.</li>
 *     <li>{@code ORDER}: Path variable indicating the sorting order (e.g., ascending or descending).</li>
 *     <li>{@code ITERATIONS}: Path variable indicating the number of iterations for sorting operations.</li>
 * </ul>
 *
 * <p>Usage Example:</p>
 * <pre>{@code
 * // Full endpoint for sorting a float array with order and iterations:
 * String endpoint = BASE + GET + ARRAY + FLOAT + ORDER + ITERATIONS;
 * }</pre>
 *
 * @author caprimol
 * @version 1.0
 * @since 2025-01-27
 */

public class RestEndpoints {

    /** The base path for the REST API. */
    public static final String BASE = "/IOS/api";

    /** Sub-path for HTTP GET requests. */
    public static final String GET = "/get";

    /** Sub-path for array-related operations. */
    public static final String ARRAY = "/array";

    /** Sub-path for float array-related operations. */
    public static final String FLOAT = "/float";

    /** Sub-path for string array-related operations. */
    public static final String STRING = "/string";

    /** Path variable indicating the sorting order (e.g., ascending or descending). */
    public static final String ORDER = "/{order}";

    /** Path variable indicating the number of iterations for sorting operations. */
    public static final String ITERATIONS = "/{iterations}";

    //public static final String STRATEGY_TYPE = "/{strategyType}";
}
