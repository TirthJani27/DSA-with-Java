import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

class KthLargestSol {
    static class KthLargest {
        PriorityQueue<Integer> minHeap;
        int size;

        public KthLargest(int k, int[] nums) {
            minHeap = new PriorityQueue<>();
            size = k;
            for (int n : nums) {
                minHeap.offer(n);
                if (minHeap.size() > size) {
                    minHeap.poll();
                }
            }
        }

        public int add(int val) {
            minHeap.offer(val);
            if (minHeap.size() > size) {
                minHeap.poll();
            }

            return minHeap.peek();
        }
    }


    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 11 };
        KthLargest kpq = new KthLargest(2, arr);
        System.out.println(kpq.add(22));
    }
}
