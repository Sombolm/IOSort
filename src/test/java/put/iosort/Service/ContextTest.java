package put.iosort.Service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import put.iosort.Config.Order;
import put.iosort.Entity.SortingResult.SortingResult;
import put.iosort.Service.Factory.StrategyFactory;
import put.iosort.Service.Strategy.Strategy;
import put.iosort.Service.Strategy.StrategyType;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ContextTest {

    @Autowired
    private Context context;

    @MockBean
    private StrategyFactory strategyFactory;

    @MockBean
    private Strategy strategy;

    @Test
    void testHandleContext_IntArray_InsertionSort() {
        int[] inputArray = {5, 2, 9};
        StrategyType[] strategies = {StrategyType.INSERTION};
        Order order = Order.ASC;

        int[] sortedArray = {2, 5, 9};
        when(strategyFactory.makeStrategy(StrategyType.INSERTION)).thenReturn(strategy);
        when(strategy.sort(any(int[].class), eq(order), eq(1))).thenReturn(sortedArray);

        List<SortingResult> results = context.handleContext(inputArray, strategies, order, 1);

        assertEquals(1, results.size());
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(results.get(0).sortedArray));
        verify(strategyFactory).makeStrategy(StrategyType.INSERTION);
        verify(strategy).sort(any(int[].class), eq(order), eq(1));
    }

    @Test
    void testHandleContext_IntArray_SelectionSort() {
        int[] inputArray = {10, 3, 7};
        StrategyType[] strategies = {StrategyType.SELECTION};
        Order order = Order.DESC;

        int[] sortedArray = {10, 7, 3};
        when(strategyFactory.makeStrategy(StrategyType.SELECTION)).thenReturn(strategy);
        when(strategy.sort(any(int[].class), eq(order), eq(1))).thenReturn(sortedArray);

        List<SortingResult> results = context.handleContext(inputArray, strategies, order, 1);

        assertEquals(1, results.size());
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(results.get(0).sortedArray));
        verify(strategyFactory).makeStrategy(StrategyType.SELECTION);
        verify(strategy).sort(any(int[].class), eq(order), eq(1));
    }

    @Test
    void testHandleContext_IntArray_BubbleSort() {
        int[] inputArray = {8, 2, 6};
        StrategyType[] strategies = {StrategyType.BUBBLE};
        Order order = Order.ASC;

        int[] sortedArray = {2, 6, 8};
        when(strategyFactory.makeStrategy(StrategyType.BUBBLE)).thenReturn(strategy);
        when(strategy.sort(any(int[].class), eq(order), eq(1))).thenReturn(sortedArray);

        List<SortingResult> results = context.handleContext(inputArray, strategies, order, 1);

        assertEquals(1, results.size());
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(results.get(0).sortedArray));
        verify(strategyFactory).makeStrategy(StrategyType.BUBBLE);
        verify(strategy).sort(any(int[].class), eq(order), eq(1));
    }

    @Test
    void testHandleContext_IntArray_CountingSort() {
        int[] inputArray = {4, 1, 0};
        StrategyType[] strategies = {StrategyType.COUNTING};
        Order order = Order.ASC;

        int[] sortedArray = {0, 1, 4};
        when(strategyFactory.makeStrategy(StrategyType.COUNTING)).thenReturn(strategy);
        when(strategy.sort(any(int[].class), eq(order), eq(1))).thenReturn(sortedArray);

        List<SortingResult> results = context.handleContext(inputArray, strategies, order, 1);

        assertEquals(1, results.size());
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(results.get(0).sortedArray));
        verify(strategyFactory).makeStrategy(StrategyType.COUNTING);
        verify(strategy).sort(any(int[].class), eq(order), eq(1));
    }

    @Test
    void testHandleContext_IntArray_HeapSort() {
        int[] inputArray = {3, 1, 5, 2};
        StrategyType[] strategies = {StrategyType.HEAP};
        Order order = Order.DESC;

        int[] sortedArray = {5, 3, 2, 1};
        when(strategyFactory.makeStrategy(StrategyType.HEAP)).thenReturn(strategy);
        when(strategy.sort(any(int[].class), eq(order), eq(1))).thenReturn(sortedArray);

        List<SortingResult> results = context.handleContext(inputArray, strategies, order, 1);

        assertEquals(1, results.size());
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(results.get(0).sortedArray));
        verify(strategyFactory).makeStrategy(StrategyType.HEAP);
        verify(strategy).sort(any(int[].class), eq(order), eq(1));
    }

    @Test
    void testHandleContext_IntArray_BogoSort() {
        int[] inputArray = {2, 1, 5};
        StrategyType[] strategies = {StrategyType.BOGO};
        Order order = Order.ASC;

        int[] sortedArray = {1, 2, 5};
        when(strategyFactory.makeStrategy(StrategyType.BOGO)).thenReturn(strategy);
        when(strategy.sort(any(int[].class), eq(order), eq(1))).thenReturn(sortedArray);

        List<SortingResult> results = context.handleContext(inputArray, strategies, order, 1);

        assertEquals(1, results.size());
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(results.get(0).sortedArray));
        verify(strategyFactory).makeStrategy(StrategyType.BOGO);
        verify(strategy).sort(any(int[].class), eq(order), eq(1));
    }
}