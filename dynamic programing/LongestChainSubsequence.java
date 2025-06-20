import java.util.Arrays;

public class LongestChainSubsequence {
    public static int longestChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Integer[][] dp;
        int n = words.length;
        dp = new Integer[n][n];
        return fun(words, 0, -1, dp);
    }

    public static int fun(String[] words, int i, int prev, Integer[][] dp) {
        if (i == words.length)
            return 0;
        int take = 0;
        if (dp[i][prev + 1] != null)
            return dp[i][prev + 1];
        if (prev == -1 || checkChain(words[i], words[prev]))
            take = 1 + fun(words, i + 1, i, dp);
        int notake = fun(words, i + 1, prev, dp);
        return dp[i][prev+1] = Math.max(take, notake);
    }

    public static boolean checkChain(String s1, String s2) {
        if (s1.length() != s2.length() + 1)
            return false;
        int i = 0;
        int j = 0;
        while (i < s1.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
                if (j == s2.length())
                    return true;

            }
            i++;
        }
        if (j == s2.length())
            return true;
        return false;
    }

    public static void main(String[] args) {
        String[] arr = { "a", "b", "ba", "abc", "abd", "bdca" };
        System.out.println(longestChain(arr));
    }
}
