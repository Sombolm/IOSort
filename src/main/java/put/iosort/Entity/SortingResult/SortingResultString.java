package put.iosort.Entity.SortingResult;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

    public SortingResultString(String[] sortedArray, long duration) {
        this.sortedArray = sortedArray;
        this.duration = duration;
    }
}