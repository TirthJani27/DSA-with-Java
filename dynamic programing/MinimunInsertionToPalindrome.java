public class MinimunInsertionToPalindrome {
    // Same code as Longest Palindromic Subsequence

    public static void main(String[] args) {
        String s1 = "abcaa";
        String s2 = new StringBuilder(s1).reverse().toString();
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
        int ans = s1.length() - dp[s1.length()][s2.length()];
        System.out.println(ans);
    }
}
