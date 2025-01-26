package put.iosort.Entity.SortingResult;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import put.iosort.Service.Strategy.StrategyType;

/**
 * Output structure for strings.
 * @author caprimol
 * @version 1.0
 * @since 2024-12-15
 */

//@NoArgsConstructor
//@AllArgsConstructor
//public class SortingResultString {
//
//    public String[] sortedArray;
//    public long duration;
//}
public class SortingResultString {

    public String[] sortedArray;
    public long duration;
    public StrategyType strategyType;

    public SortingResultString(String[] sortedArray, long duration, StrategyType strategyType) {
        this.sortedArray = sortedArray;
        this.duration = duration;
        this.strategyType = strategyType;
    }
}