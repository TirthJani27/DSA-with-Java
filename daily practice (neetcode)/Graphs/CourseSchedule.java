import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Topological sort first
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int index = 0; index < numCourses; index++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < indegree.length; i++) {
            for (int j : graph.get(i)) {
                indegree[j]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int i : graph.get(node)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }

        if (topo.size() == numCourses) {
            return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {
                { 1, 0 },
                { 0, 1 }
        };
        System.out.println(canFinish(2, array));
    }

}
