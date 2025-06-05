public class Knaksack {
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int[][] dp = new int[weights.length][capacity + 1];
        return fun(weights, values, capacity, weights.length - 1, dp);
    }

    public static int fun(int[] weights, int[] values, int capacity, int i, int[][] dp) {
        if (i == 0) {
            if (weights[0] <= capacity) {
                return values[0];
            }
            return 0;
        }
        if (capacity <= 0) {
            return 0;
        }
        if (dp[i][capacity] != 0) {
            return dp[i][capacity];
        }
        int notTake = fun(weights, values, capacity, i - 1, dp);
        int take = Integer.MIN_VALUE;
        if (weights[i] <= capacity) {
            take = fun(weights, values, capacity - weights[i], i - 1, dp) + values[i];
        }
        dp[i][capacity] = Math.max(take, notTake);
        return dp[i][capacity];
    }

    public static void main(String[] args) {
        int[][] arr = { { 3, 4, 5 }, { 30, 50, 60 } };
        System.out.println(knapsack(arr[0], arr[1], 8));
    }
}
