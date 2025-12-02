package Arrays;
// revisions = 2
import java.util.ArrayList;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // resultant interval
        ArrayList<Interval> result = new ArrayList<>();

        int i = 0;

        // adding those intervals which end before the start of new interval
        while (i < intervals.size() && intervals.get(i).end <= newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }

        // adding those intervals which overlap
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {

            // merging the intervals
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);

            i++;

        }
        result.add(newInterval);

        // adding the remaining intervals which start after the end of this new interval
        while (i < intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }

        return result;

    }

}