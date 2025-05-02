import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduling {
    static class Pair {
        int wait;
        int count;

        Pair(int wait, int count) {
            this.wait = wait;
            this.count = count;
        }
    }

    public static int leastInterval(char[] task, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        if (n == 0)
            return task.length;
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < task.length; i++) {
            if (map1.containsKey(task[i])) {
                map1.put(task[i], map1.get(task[i]) + 1);
            } else {
                map1.put(task[i], 1);
            }
        }
        for (HashMap.Entry<Character, Integer> entry : map1.entrySet()) {
            pq.add(entry.getValue());
        }
        while (!pq.isEmpty() || !q.isEmpty()) {
            ans += 1;
            if (!pq.isEmpty()) {
                int curr = pq.poll() - 1;
                if (curr > 0) {
                    q.add(new Pair(ans + n, curr));
                }
            }
            if (!q.isEmpty() && q.peek().wait == ans) {
                pq.add(q.poll().count);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[] task = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println(leastInterval(task, n));
    }
}
