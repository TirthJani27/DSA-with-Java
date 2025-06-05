import java.util.Arrays;

public class MinimumCoins {
    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] is : dp) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }
        int ans = fun(coins, amount, coins.length - 1, dp);
        if (ans >= 1000000000) {
            return -1;
        }
        return ans;
    }

    public static int fun(int[] coins, int amount, int i, int dp[][]) {
        if (amount == 0) {
            return 0;
        }
        if (i == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }
            return 1000000000;
        }
        if (dp[i][amount] != Integer.MAX_VALUE) {
            return dp[i][amount];
        }
        int take = Integer.MAX_VALUE;
        int notTake = fun(coins, amount, i - 1, dp);
        if (amount >= coins[i]) {
            take = 1 + fun(coins, amount - coins[i], i, dp);
        }
        dp[i][amount] = Math.min(take, notTake);
        return Math.min(take, notTake);
    }

    public static void main(String[] args) {
        int tar = 6249;
        int[] coins = { 186, 419, 83, 408 };
        System.out.println(coinChange(coins, tar));
    }
}
