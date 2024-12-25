package put.iosort.Service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import put.iosort.Config.Order;
import put.iosort.Entity.SortingResult.SortingResult;
import put.iosort.Entity.SortingResult.SortingResultFloat;
import put.iosort.Entity.SortingResult.SortingResultString;
import put.iosort.Service.Factory.StrategyFactory;
import put.iosort.Service.Strategies.InsertionSort;
import put.iosort.Service.Strategy.Strategy;
import put.iosort.Service.Strategy.StrategyType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@SpringBootTest
public class ContextTest {

    @Autowired
    private Context context;

    @MockBean
    private StrategyFactory strategyFactory;

    @MockBean
    private InsertionSort insertionSort;

    @Test
    public void testHandleContextWithInsertionSort() {
        // Arrange
        int[] inputArray = {4, 2, 7, 1};
        int[] sortedArray = {1, 2, 4, 7};
        StrategyType[] strategyTypes = {StrategyType.INSERTION};
        Order order = Order.ASC;

        Mockito.when(strategyFactory.makeStrategy(any())).thenReturn(insertionSort);
        Mockito.when(insertionSort.sort(any(int[].class), eq(order))).thenReturn(sortedArray);

        // Act
        List<SortingResult> results = context.handleContext(inputArray, strategyTypes, order);

        // Assert
        assertEquals(1, results.size());
        assertArrayEquals(sortedArray, results.get(0).sortedArray);
    }

    @Test
    public void testHandleContextWithInsertionSortAndOrderDESC() {
        // Arrange
        int[] inputArray = {4, 2, 7, 1};
        int[] sortedArray = {7, 4, 2, 1};
        StrategyType[] strategyTypes = {StrategyType.INSERTION};
        Order order = Order.DESC;

        Mockito.when(strategyFactory.makeStrategy(any())).thenReturn(insertionSort);
        Mockito.when(insertionSort.sort(any(int[].class), eq(order))).thenReturn(sortedArray);

        // Act
        List<SortingResult> results = context.handleContext(inputArray, strategyTypes, order);

        // Assert
        assertEquals(1, results.size());
        assertArrayEquals(sortedArray, results.get(0).sortedArray);
    }

    @Test
    public void testHandleContextWithInsertionSortAndOrderDESCAndIterations() {
        // Arrange
        int[] inputArray = {4, 2, 7, 1};
        int[] sortedArray = {7, 4, 2, 1};
        StrategyType[] strategyTypes = {StrategyType.INSERTION};
        Order order = Order.DESC;
        int iterations = 10;

        Mockito.when(strategyFactory.makeStrategy(any())).thenReturn(insertionSort);
        Mockito.when(insertionSort.sort(any(int[].class), eq(order), eq(iterations))).thenReturn(sortedArray);

        // Act
        List<SortingResult> results = context.handleContext(inputArray, strategyTypes, order, iterations);

        // Assert
        assertEquals(1, results.size());
        assertArrayEquals(sortedArray, results.get(0).sortedArray);
    }

    @Test
    public void testHandleContextWithInsertionSortAndOrderASCAndIterations() {
        // Arrange
        int[] inputArray = {4, 2, 7, 1};
        int[] sortedArray = {1, 2, 4, 7};
        StrategyType[] strategyTypes = {StrategyType.INSERTION};
        Order order = Order.ASC;
        int iterations = 10;

        Mockito.when(strategyFactory.makeStrategy(any())).thenReturn(insertionSort);
        Mockito.when(insertionSort.sort(any(int[].class), eq(order), eq(iterations))).thenReturn(sortedArray);

        // Act
        List<SortingResult> results = context.handleContext(inputArray, strategyTypes, order, iterations);

        // Assert
        assertEquals(1, results.size());
        assertArrayEquals(sortedArray, results.get(0).sortedArray);
    }

    @Test
    public void testHandleContextWithInsertionSortAndOrderASCAndIterationsAndFloatArray() {
        // Arrange
        float[] inputArray = {4.0f, 2.0f, 7.0f, 1.0f};
        float[] sortedArray = {1.0f, 2.0f, 4.0f, 7.0f};
        StrategyType[] strategyTypes = {StrategyType.INSERTION};
        Order order = Order.ASC;
        int iterations = 10;

        Mockito.when(strategyFactory.makeStrategy(any())).thenReturn(insertionSort);
        Mockito.when(insertionSort.sort(any(float[].class), eq(order), eq(iterations))).thenReturn(sortedArray);

        // Act
        List<SortingResultFloat> results = context.handleContext(inputArray, strategyTypes, order, iterations);

        // Assert
        assertEquals(1, results.size());
        assertArrayEquals(sortedArray, results.get(0).sortedArray);
    }

    @Test
    public void testHandleContextWithInsertionSortAndOrderASCAndIterationsAndStringArray() {
        // Arrange
        String[] inputArray = {"4", "2", "7", "1"};
        String[] sortedArray = {"1", "2", "4", "7"};
        StrategyType[] strategyTypes = {StrategyType.INSERTION};
        Order order = Order.ASC;
        int iterations = 10;

        Mockito.when(strategyFactory.makeStrategy(any())).thenReturn(insertionSort);
        Mockito.when(insertionSort.sort(any(String[].class), eq(order), eq(iterations))).thenReturn(sortedArray);

        // Act
        List<SortingResultString> results = context.handleContext(inputArray, strategyTypes, order, iterations);

        // Assert
        assertEquals(1, results.size());
        assertArrayEquals(sortedArray, results.get(0).sortedArray);
    }

}