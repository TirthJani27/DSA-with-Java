import java.util.*;

public class RedundantGraph {
    public static int[] findRedundantConnection(int[][] edges) {
        int[] ans = new int[2];
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
            HashSet<Integer> vis = new HashSet<>();
            if (isCycle(graph, u, -1, vis)) {
                ans[0] = u;
                ans[1] = v;
                return ans;
            }
        }
        System.out.println(graph);
        return ans;
    }

    public static boolean isCycle(HashMap<Integer, ArrayList<Integer>> graph, int curr, int prev,
            HashSet<Integer> vis) {
        for (int i : graph.get(curr)) {
            if (i != prev && vis.contains(i)) {
                return true;
            }
        }
        vis.add(curr);
        for (int i : graph.get(curr)) {
            if (i != prev && isCycle(graph, i, curr, vis)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 1, 2 },
                { 1, 3 },
                { 2, 3 }
        };
        printArray(findRedundantConnection(edges));

    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}