import java.util.Arrays;

public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        // return helper(nums, target, nums.length - 1);

        int total = 0;
        for (int i : nums) {
            total += i;
        }
        int[][] dp = new int[nums.length][total + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        int ans = fun(nums, target, nums.length - 1, 0, total, dp);
        return ans;
    }

    // Tabulation of way 2
    public static int findTargetSumWaysTab(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int num : nums)
            total += num;
        // The possible sum range is from -total to +total
        int offset = total;
        int[][] dp = new int[n][2 * total + 1];

        // Base case: first number can be added or subtracted
        dp[0][nums[0] + offset] += 1;
        dp[0][-nums[0] + offset] += 1;

        for (int i = 1; i < n; i++) {
            for (int sum = -total; sum <= total; sum++) {
                int idx = sum + offset;
                if (dp[i - 1][idx] > 0) {
                    int plus = sum + nums[i] + offset;
                    int minus = sum - nums[i] + offset;
                    if (plus >= 0 && plus < 2 * total + 1)
                        dp[i][plus] += dp[i - 1][idx];
                    if (minus >= 0 && minus < 2 * total + 1)
                        dp[i][minus] += dp[i - 1][idx];
                }
            }
        }
        return (target + offset >= 0 && target + offset < 2 * total + 1) ? dp[n - 1][target + offset] : 0;
    }

    // Reccursion way 2
    public static int fun(int[] nums, int tar, int i, int sum, int total, int[][] dp) {
        if (i == 0) {
            if (tar == Math.abs(total - sum)) {
                return 1;
            }
            return 0;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int notTake = fun(nums, tar, i - 1, sum, total, dp);
        int take = fun(nums, tar, i - 1, sum + nums[i], total - nums[i], dp);
        dp[i][sum] = notTake + take;
        return dp[i][sum];
    }

    // Reccursion way 1
    public static int helper(int[] nums, int target, int i) {
        if (i == 0) {
            int ans = 0;
            if (target - nums[i] == 0) {
                ans++;
            }
            if (target + nums[i] == 0) {
                ans++;
            }
            return ans;
        }
        int add = helper(nums, target - nums[i], i - 1);
        int min = helper(nums, target + nums[i], i - 1);
        return add + min;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3 };
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
}
