package put.iosort.Entity.SortingResult;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

    public SortingResultFloat(float[] sortedArray, long duration) {
        this.sortedArray = sortedArray;
        this.duration = duration;
    }
}