public class EqualSumGridPartitionI {
    public static boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;

        // Compute total sum
        for (int[] row : grid) {
            for (int val : row) {
                total += val;
            }
        }

        // If total sum is odd, no equal partition is possible
        if (total % 2 != 0)
            return false;

        // Try horizontal cuts (between rows)
        for (int cut = 1; cut < m; cut++) {
            int sum = 0;
            for (int i = 0; i < cut; i++) {
                for (int j = 0; j < n; j++) {
                    sum += grid[i][j];
                }
            }
            if (sum * 2 == total)
                return true;
        }

        // Try vertical cuts (between columns)
        for (int cut = 1; cut < n; cut++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < cut; j++) {
                    sum += grid[i][j];
                }
            }
            if (sum * 2 == total)
                return true;
        }

        return false;
    }
    public static void main(String[] args) {
        int[][] array = {
                { 1, 2 },
                { 4, 3 }
        };
        System.out.println(canPartitionGrid(array));
    }
}
