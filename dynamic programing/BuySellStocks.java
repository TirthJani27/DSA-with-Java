public class BuySellStocks {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int mini = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = { 17, 10, 5, 3, 2, 1 };
        System.out.println(maxProfit(prices));
    }
}
