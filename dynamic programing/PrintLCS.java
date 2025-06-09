public class PrintLCS {
    // LCS problem Tabulation method
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
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
        int i = s1.length();
        int j = s2.length();
        char[] ans = new char[dp[s1.length()][s2.length()]];
        int k = ans.length - 1;
        while (i != 0 || j != 0 && k >= 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans[k] = s1.charAt(i - 1);
                i--;
                j--;
                k--;
            } else {
                int up = dp[i - 1][j];
                int left = dp[i][j - 1];
                if (up > left) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        for (int k2 = 0; k2 < ans.length; k2++) {
            System.out.print(ans[k2]);
            
        }
    }
}
