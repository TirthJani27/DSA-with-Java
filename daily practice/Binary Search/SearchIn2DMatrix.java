
class SearchIn2DMatrix {

    public static boolean searchMatrix(int[][] mat, int tar) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][mat[0].length-1] > tar) {
                int left = 0;
                int right = mat[0].length - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (mat[i][mid] == tar) {
                        return true;
                    } else if (mat[i][mid] > tar) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.print(searchMatrix(mat, 55));
    }
}
