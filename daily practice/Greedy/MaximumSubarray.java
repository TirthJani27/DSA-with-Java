public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int sum = 0;
        while (i < nums.length) {
            sum += nums[i];
            if (max < nums[i]) {
                max = nums[i];
            }
            if (sum < 0) {
                sum = 0;
            }
            if (sum > max) {
                max = sum;
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int ans = maxSubArray(arr);
        System.out.println(ans);
    }
}
