public class JumpGame {
    public static boolean canJump(int[] nums) {
        if (nums[0] == 0 && nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int maxIdx = 0;
        int i = 0;
        while (i < nums.length && i <= maxIdx) {
            maxIdx = Math.max(i + nums[i], maxIdx);
            i++;
        }
        System.out.println(maxIdx);
        if (maxIdx >= nums.length - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 0, 1, 0 };
        System.out.println(canJump(nums));
    }
}
