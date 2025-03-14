import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, new HashSet<>(), new ArrayList<>(), ans);
        return ans;
    }

    public static void dfs(int[] nums, HashSet<Integer> visited, List<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                temp.add(nums[i]);
                dfs(nums, visited, temp, ans);
                temp.remove(temp.size() - 1);
                visited.remove(i);
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(permute(arr));
    }
}