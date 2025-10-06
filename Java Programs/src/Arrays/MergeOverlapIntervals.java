package Arrays;
// revisions = 1
import java.util.ArrayList;
import java.util.*;

public class MergeOverlapIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // getting the size of given intervals
        int n = intervals.size();

        ArrayList<Interval> result = new ArrayList<>();

        // sorting the given list of intervals (according to start time)
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        // starting with current interval
        Interval current = intervals.get(0);
        for(int i = 1; i < n; i++){
            Interval next = intervals.get(i);

            if(current.end >= next.start){
                // overlapping condition
                current.end = Math.max(current.end, next.end);
            }else{
                // setting the current list to result
                result.add(current);

                // setting the new current for other intervals
                current = next; 
            }
        }

        // adding the last interval
        result.add(current);

        return result;
    }
}
