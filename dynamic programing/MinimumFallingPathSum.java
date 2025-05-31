import java.util.Arrays;

public class MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] is : dp) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < matrix.length; j++) {
            int curr = dfs(0, j, matrix, dp);
            if (curr < min) {
                min = curr;
            }
        }
        return min;
    }

    public static int dfs(int i, int j, int[][] matrix, int[][] dp) {

        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == matrix.length - 1) {
            return matrix[i][j];
        }
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }
        int ld = dfs(i + 1, j - 1, matrix, dp);
        int d = dfs(i + 1, j, matrix, dp);
        int rd = dfs(i + 1, j + 1, matrix, dp);
        return dp[i][j] = Math.min(Math.min(ld, d), rd) + matrix[i][j];
    }

    public static void main(String[] args) {
        int[][] arr = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(minFallingPathSum(arr));
    }
}
