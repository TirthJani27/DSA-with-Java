import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    @SuppressWarnings("unchecked")
    public static int lastStoneWeight(int[] arr) {
        PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr)
            pq.add(i);

        while (pq.size() >= 2) {
            int a = (int) pq.poll();
            int b = (int) pq.poll();
            if (a != b) {
                pq.add(Math.abs(a - b));
            }
        }
        if (!pq.isEmpty()) {
            return (int) pq.poll();
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 4, 1, 8, 1 };
        System.out.println(lastStoneWeight(arr));
    }
}
