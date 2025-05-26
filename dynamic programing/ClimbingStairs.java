public class ClimbingStairs {

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n == 1)
            return 1;
        helper(n, dp);
        return dp[n];
    }

    public static int helper(int curr, int[] dp) {
        if (curr == 1) {
            return 1;
        }
        if (curr == 2) {
            return 2;
        }
        if (dp[curr] != 0) {
            return dp[curr];
        }
        dp[curr] = helper(curr - 1, dp) + helper(curr - 2, dp);
        return dp[curr];

    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }
}
