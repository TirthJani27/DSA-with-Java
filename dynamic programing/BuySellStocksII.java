import java.util.Arrays;

public class BuySellStocksII {
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return fun(prices, 0, 1, dp);
    }

    // Reccusion
    public static int fun(int[] prices, int idx, int buy, int[][] dp) {
        if (idx == prices.length)
            return 0;
        int ans = 0;
        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }
        if (buy == 1) {
            ans = Math.max(fun(prices, idx + 1, 0, dp) - prices[idx], fun(prices, idx + 1, 1, dp));
        } else {
            ans = Math.max(fun(prices, idx + 1, 1, dp) + prices[idx], fun(prices, idx + 1, 0, dp));
        }
        return dp[idx][buy] = ans;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 10, 5, 31, 2, 1 };
        System.out.println(maxProfit(prices));
    }
}
