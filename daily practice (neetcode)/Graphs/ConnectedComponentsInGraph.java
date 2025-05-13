import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

public class ConnectedComponentsInGraph {
    public static int countComponents(int n, int[][] edges) {
        int count = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            System.out.println(graph);
        }
        HashSet<Integer> hs = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (hs.size() - 1 != n) {
                if (!hs.contains(i)) {
                    count++;
                    System.out.println(count);
                    q.add(i);
                    while (!q.isEmpty()) {
                        int curr = q.poll();
                        hs.add(curr);
                        for (int j : graph.get(curr)) {
                            if (!hs.contains(j)) {
                                q.add(j);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 3, 4 }
        };
        System.out.println(countComponents(5, edges));
    }
}
