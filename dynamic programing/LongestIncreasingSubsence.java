public class LongestIncreasingSubsence {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        Integer[][] dp;
        dp = new Integer[nums.length + 1][nums.length + 1];
        return fun(0, -1, nums, dp);
    }

    public static int fun(int i, int previ, int[] arr, Integer[][] dp) {
        if (i == arr.length)
            return 0;
        if (dp[i][previ + 1] != null)
            return dp[i][previ + 1];
        int take = 0;
        if (previ == -1 || arr[i] > arr[previ])
            take = 1 + fun(i + 1, i, arr, dp);
        int notake = fun(i + 1, previ, arr, dp);
        dp[i][previ + 1] = Math.max(take, notake);
        return dp[i][previ + 1];
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));
    }
}