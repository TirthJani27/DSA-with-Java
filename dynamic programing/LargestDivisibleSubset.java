import java.util.ArrayList;
import java.util.List;

public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();
        java.util.Arrays.sort(nums);
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(nums[0]);
        for (int i = 1; i < n; i++) {
            List<Integer> maxList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp.get(j).size() > maxList.size()) {
                    maxList = dp.get(j);
                }
            }
            dp.get(i).addAll(maxList);
            dp.get(i).add(nums[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (List<Integer> l : dp) {
            if (l.size() > res.size()) {
                res = l;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(largestDivisibleSubset(arr));
    }
}
