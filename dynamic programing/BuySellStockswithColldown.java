public class BuySellStockswithColldown {
    public static int maxProfit(int[] prices) {
        Integer dp[][] = new Integer[prices.length][2];
        return fun(0, 0, prices, dp);
    }

    public static int fun(int i, int buy, int[] prices, Integer[][] dp) {
        if (i >= prices.length)
            return 0;
        if (dp[i][buy] != null)
            return dp[i][buy];
        int ans = 0;
        if (buy == 0)
            ans = Math.max(-prices[i] + fun(i + 1, 1, prices, dp), fun(i + 1, buy, prices, dp));
        else
            ans = Math.max(prices[i] + fun(i + 2, 0, prices, dp), fun(i + 1, buy, prices, dp));
        return dp[i][buy] = ans;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 1, 5 };
        System.out.println(maxProfit(prices));
    }
}
