import java.util.*;

public class MergeInterval {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(
                        merged.getLast()[1],
                        interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 8, 9 }, { 9, 11 }, { 15, 18 }, { 2, 4 }, { 16, 17 } };
        intervals = merge(intervals);
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(intervals[i][j] + " ");
            }
            System.out.println();
        }
    }
}
