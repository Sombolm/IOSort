package put.iosort.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import put.iosort.Config.Order;
import put.iosort.Service.Factory.StrategyFactory;
import put.iosort.Service.Strategy.Strategy;
import put.iosort.Service.Strategy.StrategyType;

@Service
@AllArgsConstructor
public class Context {
    private final StrategyFactory strategyFactory;


    public int[] handleContext(int[] numbers, StrategyType strategyType, Order order) {

        Strategy strategy = strategyFactory.makeStrategy(strategyType);

        return strategy.sort(numbers, order);
    }
}
