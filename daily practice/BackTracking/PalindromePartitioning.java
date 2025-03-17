import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {

    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {

                return false;
            }
        }
        return true;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(0, s, new ArrayList<>(), ans);
        return ans;
    }

    public static void dfs(int start, String s, List<String> temp, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < s.length(); ++i) {
            String left = s.substring(start, i + 1);
            if (isPalindrome(left)) {
                temp.add(left);
                dfs(i + 1, s, temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}