public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abzd";
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        int max = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                    }
                }
            }
        }
        System.out.println(max);
    }
}