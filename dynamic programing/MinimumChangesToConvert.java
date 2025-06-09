public class MinimumChangesToConvert {
    public static int minChangesToConvert(String s1, String s2) {
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
        return s1.length() + s2.length() - (dp[s1.length()][s2.length()] * 2);
    }

    public static void main(String[] args) {
        System.out.println(minChangesToConvert("abc", "bcd"));
    }
}
