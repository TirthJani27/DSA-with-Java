import java.util.PriorityQueue;

public class KthNearestPoint {
    static class Pair {
        int x;
        int y;
        double dist;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = Math.sqrt(x * x + y * y);
        }

    }

    public static int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(a.dist, b.dist));
        for (int i = 0; i < points.length; i++) {
            pq.add(new Pair(points[i][0], points[i][1]));
        }
        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] points = { { 1, 3 }, { -2, 2 } };
        kClosest(points, 1);
    }
}
