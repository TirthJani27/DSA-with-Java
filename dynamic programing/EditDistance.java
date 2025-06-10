public class EditDistance {
    public static int minDistance(String word1, String word2) {
        Integer[][] dp;
        dp = new Integer[word1.length()][word2.length()];
        return fun(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    }

    public static int fun(String s1, String s2, int i1, int i2, Integer[][] dp) {
        if (i1 < 0)
            return i2 + 1;
        if (i2 < 0)
            return i1 + 1;
        if (dp[i1][i2] != null)
            return dp[i1][i2];

        // No Change
        if (s1.charAt(i1) == s2.charAt(i2))
            return 0 + fun(s1, s2, i1 - 1, i2 - 1, dp);

        // Insertion
        int insertion = fun(s1, s2, i1, i2 - 1, dp) + 1;
        int delete = fun(s1, s2, i1 - 1, i2, dp) + 1;
        int replace = fun(s1, s2, i1 - 1, i2 - 1, dp) + 1;
        return dp[i1][i2] = (Math.min(insertion, Math.min(delete, replace)));
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(minDistance(s1, s2));
    }
}
