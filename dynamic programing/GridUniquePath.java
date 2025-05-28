public class GridUniquePath {

    public static int uniquePaths(int m, int n) {
        // int count = fun(0, 0, m, n);
        int dp[][] = new int[m][n];
        int abs = fun(0,0,dp);
        return abs;
    }

    // RECCURTION APPROACH
    // public static int fun(int i, int j, int m, int n) {
    // if (i == m - 1 && j == n - 1) {
    // return 1;
    // }
    // if (i < m && j < n) {
    // int d = fun(i + 1, j, m, n);
    // int r = fun(i, j + 1, m, n);
    // return d + r;
    // }
    // return 0;
    // }

    public static int fun(int i, int j, int[][] dp) {
        if (i == dp.length - 1 && j == dp[0].length - 1) {
            return dp[dp.length - 1][dp[0].length - 1]+1;
        }
        int m = dp.length;
        int n = dp[0].length;
        if (i < m && j < n) {
            if(dp[i][j] == 0) {
                return dp[i][j] = fun(i + 1, j, dp) + fun(i,j+1, dp);
            }
            else{
                return dp[i][j];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
