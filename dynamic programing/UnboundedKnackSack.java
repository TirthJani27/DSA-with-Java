import java.util.Arrays;

public class UnboundedKnackSack {
    public static int knackSack(int[] weights, int[] values, int capacity) {
        int[][] dp = new int[weights.length][capacity + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        return fun(weights, values, capacity, values.length - 1, dp);
    }

    public static int fun(int weights[], int values[], int capacity, int i, int[][] dp) {
        if (i == 0) {
            if (capacity >= weights[i]) {
                return values[i];
            }
            return 0;
        }
        if (capacity <= 0) {
            return 0;
        }
        if (dp[i][capacity] != -1) {
            return dp[i][capacity];
        }
        int notTake = 0 + fun(weights, values, capacity, i - 1, dp);
        int take = 0;
        if (capacity >= weights[i]) {
            take = fun(weights, values, capacity - weights[i], i, dp) + values[i];
        }
        return dp[i][capacity] = Math.max(take, notTake);
    }

    public static void main(String[] args) {
        int[] weights = { 2, 4, 6 };
        int[] values = { 5, 11, 13 };
        int capacity = 10;
        int[][] dp = new int[weights.length][capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (j >= weights[i]) {
                    dp[i][j] = (j / weights[i]) * values[i];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (j >= weights[i]) {
                    take = dp[i][j - weights[i]] + values[i];
                }
                dp[i][j] = Math.max(notTake, take);
            }
        }

        System.out.println(dp[weights.length - 1][capacity]);
    }
}
