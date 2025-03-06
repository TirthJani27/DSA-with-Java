import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] arr, int tar) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        int ind = 0;
        dfs(ans, temp, arr, tar, sum, ind);
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, List<Integer> temp, int[] arr, int tar, int sum, int idx) {
        if (idx >= arr.length || sum >= tar) {
            if (sum == tar) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(arr[idx]);
        sum += arr[idx];
        dfs(ans, temp, arr, tar, sum, idx);
        temp.remove(temp.size() - 1);
        sum -= arr[idx];
        dfs(ans, temp, arr, tar, sum, idx + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 7 };
        int tar = 7;
        System.out.println(combinationSum(arr, tar));
    }
}
