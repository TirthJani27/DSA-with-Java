import java.util.ArrayList;

public class MaxLengthOfValidSubsequence {
    static int count = 2;

    public static class Pair {
        int last;
        int ans;

        Pair(int last, int ans) {
            this.last = last;
            this.ans = ans;
        }
    }

    public static int maximumLength(int[] nums, int k) {
        Pair[] dp = new Pair[nums.length];
        helper(nums, 0, new ArrayList<>(), k, dp);
        return count;
    }

    public static boolean isValid(ArrayList<Integer> list, int k, int x) {
        if (list.size() <= 1)
            return true;
        int val = (list.get(list.size() - 2) + list.get(list.size() - 1)) % k;
        if (val == ((list.get(list.size() - 1) + x) % k)) {
            count = Math.max(count, list.size() + 1);
            return true;
        }
        return false;
    }

    public static void helper(int[] nums, int i, ArrayList<Integer> arr, int k, Pair[] dp) {
        if (i == nums.length) {
            return;
        }
        helper(nums, i + 1, new ArrayList<>(arr), k, dp);
        int take = nums[i];
        if (arr.size() <= 1) {
            arr.add(take);
            helper(nums, i + 1, new ArrayList<>(arr), k, dp);
        } else if (isValid(arr, k, take)) {
            System.out.println(take);
            arr.add(take);
            System.out.println(arr);
            helper(nums, i + 1, new ArrayList<>(arr), k, dp);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 10, 2 };
        System.out.println(maximumLength(nums, 6));
    }

}