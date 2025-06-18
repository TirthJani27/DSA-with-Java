public class BuySellStocksIII {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        Integer dp[][][] = new Integer[n + 1][2][3];
        for (int i = 0; i < n; i++) {
            for (int buy = 0; buy < 2; buy++) {
                dp[i][buy][0] = 0;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int buy = 0; buy < 2; buy++) {
                dp[n][buy][i] = 0;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
                    int ans = 0;
                    if (buy == 0) {
                        ans = Math.max(dp[i + 1][1][cap] - prices[i], dp[i + 1][0][cap]);
                    } else
                        ans = Math.max(dp[i + 1][0][cap - 1] + prices[i], dp[i + 1][1][cap]);
                    dp[i][buy][cap] = ans;
                }
            }
        }
        return dp[0][0][2];
    }

    public static int fun(int[] prices, int i, int buy, int transactions, Integer[][][] dp) {
        int ans = 0;
        if (i == prices.length)
            return 0;
        if (dp[i][buy][transactions] != null)
            return dp[i][buy][transactions];
        if (transactions == 0)
            return 0;
        if (buy == 0)
            ans = Math.max(fun(prices, i + 1, 1, transactions,
                    dp) - prices[i], fun(prices, i + 1, 0, transactions, dp));
        else
            ans = Math.max(fun(prices, i + 1, 0, transactions - 1, dp) + prices[i], fun(prices, i + 1, 1, transactions,
                    dp));

        return dp[i][buy][transactions] = ans;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }
}
