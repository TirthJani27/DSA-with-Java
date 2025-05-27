class HouseRobbery {
    // This is Memoisation way

    // public static int rob(int[] nums) {
    // int[] dp = new int[nums.length];
    // int idx = nums.length-1;
    // dp[0] = nums[0];
    // dp[1] = Math.max(nums[1], nums[0]);
    // int ans = fun(dp, nums, idx);
    // return ans;
    // }
    // public static int fun(int[] dp, int[] nums, int idx) {
    // if (idx == 0) {
    // return dp[0];
    // }
    // if (idx == 1) {
    // return dp[1];
    // }
    // int pick;
    // int nonpick;
    // if (dp[idx - 2] == 0) {
    // pick = nums[idx] + fun(dp, nums, idx - 2);
    // } else {
    // pick = nums[idx] + dp[idx - 2];
    // }
    // if (dp[idx - 1] == 0) {
    // nonpick = fun(dp, nums, idx - 1);
    // } else {
    // nonpick = dp[idx - 1];
    // }
    // return Math.max(pick, nonpick);
    // }

    // Tabular method
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int take = nums[i] + dp[i - 2];
            int nottake = dp[i - 1];
            dp[i ] = Math.max(take, nottake);
            
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(rob(nums));
    }
}