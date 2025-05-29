
import java.util.ArrayList;
import java.util.HashSet;

public class MaximizetheNumberofTargetNodesAfterConnectingTreesI {
    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int[] ans = new int[edges1.length + 1];
        int info[] = findNode(edges2, k - 1);
        int val = info[1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int nodes = edges1.length + 1;
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges1.length; i++) {
            graph.get(edges1[i][0]).add(edges1[i][1]);
            graph.get(edges1[i][1]).add(edges1[i][0]);
        }
        for (int i = 0; i < graph.size(); i++) {
            HashSet<Integer> vis = new HashSet<>();
            int ans2 = dfs(graph, i, 0, k, vis, 0, 0);
            ans[i] = ans2 + val;
        }

        return ans;
    }

    public static int[] findNode(int[][] edges, int k) {
        int nodes = edges.length + 1;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int max = 0;
        int maxi = -1;
        for (int i = 0; i < graph.size(); i++) {
            HashSet<Integer> vis = new HashSet<>();
            int ans = dfs(graph, i, 0, k, vis, 0, 0);
            if (max < ans) {
                max = ans;
                maxi = i;
            }
        }
        int[] ans = new int[2];
        ans[0] = maxi;
        ans[1] = max;
        return ans;
    }

    public static int dfs(ArrayList<ArrayList<Integer>> graph, int node, int parent, int k, HashSet<Integer> vis,
            int size, int level) {
        if (k == level) {
            return size;
        }
        vis.add(node);
        for (Integer integer : graph.get(node)) {
            if (!vis.contains(integer) && integer != parent) {
                size++;
                dfs(graph, integer, node, k, vis, size, level + 1);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] edges1 = {
                { 0, 1 },
                { 0, 2 },
                { 2, 3 },
                { 2, 4 }
        };

        int[][] edges2 = {
                { 0, 1 },
                { 1, 2 },
                { 1, 3 },
                { 1, 4 },
                { 1, 5 },
                { 0, 6 },
        };
        int k = 2;
        int[] ans = maxTargetNodes(edges1, edges2, k);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
