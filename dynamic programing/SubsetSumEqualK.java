import java.util.Arrays;

public class SubsetSumEqualK {
    public static boolean subarraySum(int[] arr, int k) {
        int[][] dp = new int[k + 1][arr.length];
        dp[0][0] = 1;
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return fun(arr.length - 1, arr, k, dp);
    }

    public static boolean fun(int i, int[] arr, int k, int[][] dp) {
        if (k == 0)
            return true;
        if (i == 0)
            return k == arr[0];
        if (k < 0)
            return false;
        if (dp[k][i] != -1) {
            return dp[k][i] == 1;
        }
        boolean notTake = fun(i - 1, arr, k, dp);
        boolean take = fun(i - 1, arr, k - arr[i], dp);
        if (notTake || take) {
            dp[k][i] = 1;
        } else {
            dp[k][i] = 0;
        }
        return take || notTake;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 12, 3 };
        System.out.println(subarraySum(arr, 15));
    }
}
