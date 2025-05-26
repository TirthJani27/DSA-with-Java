public class MaxSumNonAdjecent {
    public static int nonAdjacent(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], dp[1]);
        int ans = fun(nums.length - 1, dp, nums);
        return ans;
    }

    public static int fun(int idx, int[] dp, int[] nums) {
        if (idx == 0)
            return dp[0];
        if (idx == -1)
            return 0;
        int nonpick;
        int pick;
        if (dp[idx - 1] == 0) {
            nonpick = fun(idx - 1, dp, nums);
        } else {
            nonpick =  dp[idx - 1];
        }
        if (dp[idx - 2] == 0) {
            pick = nums[idx] + fun(idx - 2, dp, nums);
        } else {
            pick = nums[idx] + dp[idx - 2];
        }
        return Math.max(nonpick, pick);
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 4, 9 };
        System.out.println(nonAdjacent(nums));
    }
}
