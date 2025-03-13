import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        HashSet<Integer> visited = new HashSet<>();
        dfs(ans, visited, new ArrayList<>(), target, 0, 0, candidates);
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, HashSet<Integer> visited, List<Integer> temp, int target, int curr,
            int index, int[] candidates) {

        if (curr == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // visited = new HashSet<>();
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            curr += candidates[i];
            temp.add(candidates[i]);
            dfs(ans, visited, temp, target, curr, i + 1, candidates);
            curr -= candidates[i];
            temp.remove(temp.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] candidates = { 1, 1, 1, 2, 2 };
        int tar = 4;
        System.out.println(combinationSum2(candidates, tar));
    }
}