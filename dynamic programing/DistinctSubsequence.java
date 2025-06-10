import java.util.Arrays;

public class DistinctSubsequence {
    // Memoization
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] is : dp)
            Arrays.fill(is, -1);
        return fun(s, t, s.length() - 1, t.length() - 1, dp);
    }

    // Reccursion
    public static int fun(String s1, String s2, int i1, int i2, int[][] dp) {
        if (i2 == -1)
            return 1;

        if (i1 == -1)
            return 0;

        if (dp[i1][i2] != -1)
            return dp[i1][i2];

        int take = 0;
        if (s1.charAt(i1) == s2.charAt(i2))
            take = fun(s1, s2, i1 - 1, i2 - 1, dp);

        int notTake = fun(s1, s2, i1 - 1, i2, dp);
        return dp[i1][i2] = take + notTake;
    }

    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int take = 0;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    take = dp[i - 1][j - 1];
                }
                int notTake = dp[i - 1][j];
                dp[i][j] = notTake + take;
            }
        }
        System.out.println(dp[m][n]);
    }
}
