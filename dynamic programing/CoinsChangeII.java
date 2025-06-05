import java.util.Arrays;

public class CoinsChangeII {
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return fun(coins, amount, coins.length - 1, dp);
    }

    public static int fun(int[] coins, int amount, int index, int dp[][]) {
        if (index == -1) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[amount][index] != -1) {
            return dp[amount][index];
        }
        if (amount == 0) {
            return 1;
        }

        int notTake = fun(coins, amount, index - 1, dp);
        int take = 0;
        if (amount >= coins[index]) {
            take = fun(coins, amount - coins[index], index, dp);
        }
        dp[amount][index] = take + notTake;
        return take + notTake;
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int tar = 5;
        // Tabulation
        int n = coins.length;
        int[][] dp = new int[n][tar + 1];
        for (int i = 0; i <= tar; i++) {
            dp[0][i] = (i % coins[0] == 0) ? 1 : 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= tar; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (j >= coins[i]) {
                    take = dp[i][j - coins[i]];
                }
                dp[i][j] = take + notTake;
            }
        }
        System.out.println(dp[n - 1][tar]);
    }
}
