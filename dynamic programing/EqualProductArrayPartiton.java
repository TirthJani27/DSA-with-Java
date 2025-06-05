public class EqualProductArrayPartiton {
    public static boolean checkEqualPartitions(int[] nums, long target) {
        if (target <= 0) return false;
        long total = 1;
        for (int i : nums) {
            total *= i;
        }
        if (total % (target * target) != 0) {
            return false;
        }
        return canPartition(nums, nums.length - 1, target);
    }

    public static boolean canPartition(int[] nums, int i, long target) {
        if (target == 1) return true;
        if (i < 0 || target < 1) return false;
        // If current number divides target, try including it
        if (target % nums[i] == 0) {
            if (canPartition(nums, i - 1, target / nums[i])) {
                return true;
            }
        }
        // Try excluding current number
        return canPartition(nums, i - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = { 8, 1, 4, 8, 4 };
        System.out.println(checkEqualPartitions(arr, 0));
    }
}
