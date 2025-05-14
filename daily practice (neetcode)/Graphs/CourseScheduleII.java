import java.util.*;

public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                ans.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int j : graph.get(curr)) {
                indegree[j]--;
                if (indegree[j] == 0) {
                    ans.add(j);
                    q.add(j);
                }
            }
        }
        if (ans.size() != numCourses)
            return new int[0];
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 1, 0 },
                { 2, 0 },
                { 3, 1 },
                { 3, 2 }
        };
        printArray(findOrder(4, edges));
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
