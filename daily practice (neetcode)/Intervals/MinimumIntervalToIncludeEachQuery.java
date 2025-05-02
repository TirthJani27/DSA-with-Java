import java.util.*;

public class MinimumIntervalToIncludeEachQuery {
    public static void printArr(int[] array) {
        for (int is : array) {
            System.out.print(is + " ");
        }
    }

    public static class Pair implements Comparable<Pair> {
        int dist;
        int right;

        Pair(int dist, int right) {
            this.dist = dist;
            this.right = right;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.dist != other.dist) {
                return Integer.compare(this.dist, other.dist);
            }
            return Integer.compare(this.right, other.right);
        }

    }

    public static int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        int sortedQueries[] = new int[queries.length];
        HashMap<Integer, Integer> queryResultMap = new HashMap<>();
        for (int k = 0; k < queries.length; k++) {
            sortedQueries[k] = queries[k];
        }
        Arrays.sort(sortedQueries);
        int iIdx = 0, qIdx = 0;
        int size = queries.length;
        while (qIdx < size) {
            int query = sortedQueries[qIdx];

            while (iIdx < intervals.length && query >= intervals[iIdx][0]) {
                minHeap.add(new Pair(intervals[iIdx][1] - intervals[iIdx][0] + 1, intervals[iIdx][1]));
                iIdx++;
            }

            while (!minHeap.isEmpty() && query > minHeap.peek().right) {
                minHeap.remove();
            }

            queryResultMap.put(query, minHeap.isEmpty() ? -1 : minHeap.peek().dist);
            qIdx++;
        }
        int result[] = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = queryResultMap.get(queries[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 4 },
                { 2, 4 },
                { 3, 6 },
                { 4, 4 }
        };
        int[] queries = { 2, 3, 4, 5 };
        int[] ans = minInterval(intervals, queries);
        printArr(ans);
    }
}