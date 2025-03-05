import java.util.ArrayList;
import java.util.List;

class AllPossibleSubsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(ans, temp, nums, 0);
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, List<Integer> temp, int[] nums, int ind) {
        if (ind == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[ind]);
        dfs(ans, temp, nums, ind + 1);
        temp.remove(temp.size() - 1);
        dfs(ans, temp, nums, ind + 1);
        return;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(subsets(arr));
    }
}