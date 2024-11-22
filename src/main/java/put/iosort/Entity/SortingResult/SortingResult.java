package put.iosort.Entity.SortingResult;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Entity
@AllArgsConstructor
public class SortingResult {

    private int[] sortedArray;
    private long duration;
}
