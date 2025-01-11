package put.iosort.Entity.SortingResult;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import put.iosort.Service.Strategy.StrategyType;

/**
 * Output structure for integers.
 * @author caprimol
 * @version 1.0
 * @since 2024-12-15
 */

//@AllArgsConstructor
//@Data
public class SortingResult {

    public int[] sortedArray;
    public long duration;
    public StrategyType strategyType;

    public SortingResult(int[] sortedArray, long duration, StrategyType strategyType) {
        this.sortedArray = sortedArray;
        this.duration = duration;
        this.strategyType = strategyType;
    }
}
