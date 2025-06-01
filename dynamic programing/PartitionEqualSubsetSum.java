import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static boolean isSubsetSum(int arr[], int sum) {
        int[][] dp = new int[sum + 1][sum + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
            if (dp[0][arr[0]] == 1) {
                return true;
            }
        }
        for (int j = 1; j < arr.length; j++) {
            for (int k = 1; k < sum; k++) {
                boolean notTake = dp[j - 1][k] == 1;
                if (k < arr[j]) {
                    dp[j][k] = 0;
                    continue;
                }
                boolean take = dp[j - 1][k - arr[j]] == 1;
                if (notTake || take) {
                    dp[j][k] = 1;
                }
            }
        }
        return dp[arr.length - 1][sum] == 1;
    }

    // Reccursion
    public static boolean fun(int arr[], int tar, int i) {
        if (tar == 0) {
            return true;
        }
        if (i == 0) {
            return tar == arr[0];
        }
        if (tar < 0) {
            return false;
        }
        return fun(arr, tar - arr[i], i - 1) || fun(arr, tar, i - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 4, 5, -1 };
        System.out.println(isSubsetSum(arr, 11));
    }
}
