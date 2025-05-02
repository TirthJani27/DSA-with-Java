import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class NonOverlapingInterval {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        for (int[] is : intervals) {
            System.out.println(is[0] + " " + is[1]);
        }
        ArrayList<int[]> merged = new ArrayList<>();
        int i = 1;
        merged.add(intervals[0]);
        while (i < intervals.length) {
            int[] curr = intervals[i];
            int[] last = merged.get(merged.size() - 1);
            if (last[1] > curr[0]) {
                count++;
            } else {
                merged.add(curr);
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] interval = {
                { -52, 31 },
                { -73, -26 },
                { 82, 97 },
                { -65, -11 },
                { -62, -49 },
                { 95, 99 },
                { 58, 95 },
                { -31, 49 },
                { 66, 98 },
                { -63, 2 },
                { 30, 47 },
                { -40, -26 }
        };
        int ans = eraseOverlapIntervals(interval);
        System.out.println(ans);
    }
}
