import java.util.Arrays;

public class CountTarSubset {
    public static int count(int[] arr, int k) {
        int[][] dp = new int[arr.length][k+1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return fun(arr, k, arr.length - 1,dp);
    }

    // Memoization approach
    public static int fun(int[] arr, int k, int i, int[][] dp) {
        if (k == 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i][k] != -1) {
            return dp[i][k];
        }
        int notTake = fun(arr, k, i - 1, dp);
        int take = 0;
        if (k >= arr[i]) {
            take = fun(arr, k - arr[i], i - 1, dp);
        }
        dp[i][k] = take + notTake;
        return dp[i][k];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3 };
        System.out.println(count(arr, 3));
    }
}
