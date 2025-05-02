import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < ans.length; i++) {
            int currTemp = temperatures[i];
            while (!s.isEmpty() && currTemp > temperatures[s.peek()]) {
                ans[s.peek()] = i - s.peek();
                s.pop();
            }
            s.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] temp = dailyTemperatures(temperatures);
        for (int i : temp) {
            System.out.print(i + " ");
        }
    }
}
