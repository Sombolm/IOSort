package put.iosort.Entity.SortingResult;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Output structure.
 * @author caprimol
 * @version 1.0
 * @since 2024-12-15
 */

//@AllArgsConstructor
//@Data
public class SortingResult {

    public int[] sortedArray;
    public long duration;

    public SortingResult(int[] sortedArray, long duration) {
        this.sortedArray = sortedArray;
        this.duration = duration;
    }
}
