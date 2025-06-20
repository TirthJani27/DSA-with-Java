public class LongestDivisibleSubset {
    public static int lds(int[] arr) {
        int n = arr.length;
        java.util.Arrays.sort(arr);
        Integer[][] dp;
        dp = new Integer[n][n];
        return fun(arr, n, 0, -1, dp);
    }

    public static int fun(int[] arr, int n, int i, int prev, Integer[][] dp) {
        if (n == i)
            return 0;
        if (dp[i][prev + 1] != null)
            return dp[i][prev + 1];
        int take = 0;
        if (prev == -1 || arr[i] % arr[prev] == 0) {
            take = 1 + fun(arr, n, i + 1, i, dp);
        }
        int nottake = fun(arr, n, i + 1, prev, dp);
        return dp[i][prev+1] = Math.max(take, nottake);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 7, 8, 4, 16 };
        System.out.println(lds(arr));
    }
}
