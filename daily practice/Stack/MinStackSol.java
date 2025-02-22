import java.util.PriorityQueue;
import java.util.Stack;

class MinStackSol {
    class MinStack {
        PriorityQueue<Integer> minHeap;
        Stack<Integer> s;

        MinStack() {
            minHeap = new PriorityQueue<>();
            s = new Stack<>();
        }

        public void push(int val) {
            s.push(val);
            minHeap.add(val);
        }

        public void pop() {
            int val = s.pop();
            minHeap.remove(val);
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {

    }
}