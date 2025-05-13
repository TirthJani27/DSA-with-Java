import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class GraphVaildTree {

    public static boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return true;
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        HashSet<Integer> hs = new HashSet<>();
        boolean flag = isCycle(n, graph, hs, -1, 0);
        System.out.println(hs);
        if (flag) {
            return false;
        }
        if (hs.size() != n) {
            return false;
        }
        return true;
    }

    public static boolean isCycle(int n, ArrayList<ArrayList<Integer>> graph, HashSet<Integer> vis, int prev,
            int curr) {
        if (vis.contains(curr)) {
            return true;
        }
        vis.add(curr);
        for (int i : graph.get(curr)) {
            if (i != prev) {
                if (isCycle(n, graph, vis, curr, i))
                    return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {
                { 0, 0 },
        };
        System.out.println(validTree(1, array));
    }
}
