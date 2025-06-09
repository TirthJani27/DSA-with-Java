import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return helper(text1, text2, text1.length() - 1, text2.length() - 1, dp);
    }

    public static int helper(String s1, String s2, int i1, int i2, int[][] dp) {
        if (i1 == -1 || i2 == -1) {
            return 0;
        }
        if (s1.charAt(i1) == s2.charAt(i2))
            return 1 + helper(s1, s2, i1 - 1, i2 - 1, dp);
        if (dp[i1][i2] != -1)
            return dp[i1][i2];

        int a1 = helper(s1, s2, i1 - 1, i2, dp);
        int a2 = helper(s1, s2, i1, i2 - 1, dp);

        return dp[i1][i2] = Math.max(a1, a2);
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        s2 = new StringBuilder(s1).reverse().toString();
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }
}
