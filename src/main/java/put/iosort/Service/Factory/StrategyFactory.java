package put.iosort.Service.Factory;

import org.springframework.stereotype.Component;
import put.iosort.Service.Strategies.*;
import put.iosort.Service.Strategy.Strategy;
import put.iosort.Service.Strategy.StrategyType;

@Component
public class StrategyFactory {
    public Strategy makeStrategy(StrategyType strategyType) {
        return switch (strategyType) {
            case SELECTION -> new SelectionSort();
            case BUBBLE -> new BubbleSort();
            case INSERTION -> new InsertionSort();
            case COUNTING -> new CountingSort();
            case HEAP -> new HeapSort();
            case SHELL -> new ShellSort();
        };
    }
}
