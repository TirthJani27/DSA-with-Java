public class HouseRobberyII {
    public static int rob2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int take = nums[i] + dp[i - 2];
            int nottake = dp[i - 1];
            dp[i] = Math.max(take, nottake);

        }
        return dp[nums.length - 1];
    }

    public static int rob(int[] nums) {
        int[] temp1 = new int[nums.length - 1], temp2 = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            temp1[i-1] = nums[i];
        }
        for (int i = 0; i < nums.length-1; i++) {
            temp2[i] = nums[i];
        }
        int left = rob2(temp1);
        int right = rob2(temp2);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums));
    }
}
