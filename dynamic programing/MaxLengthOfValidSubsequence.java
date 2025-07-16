import java.util.ArrayList;

public class MaxLengthOfValidSubsequence {
    static int count = 2;

    public static int maximumLength(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return count;
    }

    public static void isValid(ArrayList<Integer> list) {
        if (list.size() <= 2) {
            return;
        }
        int val = (list.get(0) + list.get(1)) % 2;
        for (int i = 1; i < list.size(); i++) {
            if ((list.get(i - 1) + list.get(i)) % 2 != val) {
                return;
            }
        }
        count = Math.max(count, list.size());
    }

    public static void helper(int[] nums, int i, ArrayList<Integer> arr) {
        if (i == nums.length) {
            return;
        }
        helper(nums, i + 1, new ArrayList<>(arr));
        int take = nums[i];
        if (arr.size() > 1) {
            isValid(arr);
        }
        arr.add(take);
        helper(nums, i + 1, new ArrayList<>(arr));
        if (arr.size() > 1) {
            isValid(arr);
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 1, 2 };
        System.out.println(maximumLength(nums));
    }

}