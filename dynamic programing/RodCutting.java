import java.util.Arrays;

public class RodCutting {
    public static int cutRod(int[] price) {
        int[][] dp = new int[price.length][price.length + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return fun(price, price.length, price.length - 1, dp);
    }

    public static int fun(int[] price, int n, int i, int[][] dp) {
        if (i == 0) {
            if (n >= i + 1) {
                return price[i] * n;
            }
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (dp[i][n] != -1) {
            return dp[i][n];
        }
        int notTake = fun(price, n, i - 1, dp);
        int take = 0;
        if (n >= i + 1) {
            take = price[i] + fun(price, n - i - 1, i, dp);
        }
        return dp[i][n] = Math.max(take, notTake);
    }

    public static void main(String[] args) {
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };

        System.out.println(cutRod(price));
    }
}
