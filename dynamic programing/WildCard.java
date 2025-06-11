public class WildCard {
    private static boolean recursion(String str1, String pattern, int i, int j) {
        // Base cases
        if (j < 0) {
            if (i < 0)
                return true;
            return false;
        }
        if (i < 0) {
            for (int ind = 0; ind <= j; ind++) {
                if (pattern.charAt(ind) != '*')
                    return false;
            }
            return true;
        }

        // Explore all paths
        if (str1.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') {
            return recursion(str1, pattern, i - 1, j - 1);
        }
        if (pattern.charAt(j) == '*') {
            return (recursion(str1, pattern, i, j - 1) || recursion(str1, pattern, i - 1, j));
        }
        return false;
    }

    private static boolean memoization(String str1, String pattern, int i, int j, int[][] dp) {
        // Base cases
        if (j < 0) {
            if (i < 0)
                return true;
            return false;
        }
        if (i < 0) {
            for (int ind = 0; ind <= j; ind++) {
                if (pattern.charAt(ind) != '*')
                    return false;
            }
            return true;
        }

        // Overlapped subproblem
        if (dp[i][j] != 0) {
            if (dp[i][j] == 2)
                return true;
            else
                return false;
        }

        boolean result = false;

        // Explore all paths
        if (str1.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') {
            result = memoization(str1, pattern, i - 1, j - 1, dp);
        } else if (pattern.charAt(j) == '*') {
            result = (memoization(str1, pattern, i, j - 1, dp) || memoization(str1, pattern, i - 1, j, dp));
        }

        if (result) {
            dp[i][j] = 2;
        } else
            dp[i][j] = 1;

        return result;
    }

    private static boolean tabulation(String str1, String pattern) {
        int n = str1.length();
        int m = pattern.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base cases

        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
            else
                break;
        }

        // Explore all paths
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    boolean up = dp[i - 1][j];
                    boolean left = dp[i][j - 1];
                    if (up || left) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        return dp[n][m];
    }

    private static boolean spaceOptimization(String str1, String pattern) {
        int n = str1.length();
        int m = pattern.length();

        boolean[] dp = new boolean[m + 1];

        // Base cases

        dp[0] = true;

        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*')
                dp[j] = dp[j - 1];
            else
                break;
        }

        // Explore all paths
        for (int i = 1; i <= n; i++) {
            boolean[] curr = new boolean[m + 1];
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    curr[j] = dp[j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    boolean up = dp[j];
                    boolean left = curr[j - 1];
                    if (up || left) {
                        curr[j] = true;
                    }
                }
            }
            dp = curr;
        }

        return dp[m];
    }

    public static boolean isMatch(String s, String p) {
        return spaceOptimization(s, p);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a?"));
    }
}
