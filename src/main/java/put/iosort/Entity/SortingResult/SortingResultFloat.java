package put.iosort.Entity.SortingResult;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import put.iosort.Service.Strategy.StrategyType;

/**
 * Output structure for floats.
 * @author caprimol
 * @version 1.0
 * @since 2024-12-15
 */

//@NoArgsConstructor
//@AllArgsConstructor
//public class SortingResultFloat {
//
//    public float[] sortedArray;
//    public long duration;
//}
public class SortingResultFloat {

    public float[] sortedArray;
    public long duration;
    public StrategyType strategyType;

    public SortingResultFloat(float[] sortedArray, long duration, StrategyType strategyType) {
        this.sortedArray = sortedArray;
        this.duration = duration;
        this.strategyType = strategyType;
    }
}