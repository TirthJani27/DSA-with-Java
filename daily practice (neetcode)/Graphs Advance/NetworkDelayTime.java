import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        // Build the graph
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new Pair(v, w));
        }

        // Dijkstra's algorithm using PriorityQueue
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int currentDist = current.weight;

            if (currentDist > dist[u])
                continue; // Skip if already found better path

            for (Pair neighbor : graph.get(u)) {
                int v = neighbor.node;
                int w = neighbor.weight;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        // Find the maximum distance
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }

    public static void main(String[] args) {
        int[][] array = {
                { 2, 1, 1 },
                { 2, 3, 1 },
                { 3, 4, 1 }
        };
        System.out.println(networkDelayTime(array, 4, 2));
    }
}
