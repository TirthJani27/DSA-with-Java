import java.util.HashMap;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[i].length];
                    visited[i][j] = true;
                    if (dfs(i, j, word, 1, visited, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(int i, int j, String word, int index, boolean[][] visited, char[][] board) {
        if (index == word.length()) {
            return true;
        }
        int k = i - 1, l = i + 1, m = j + 1, n = j - 1;
        if (k >= 0 && k < board.length && !visited[k][j] && board[k][j] == word.charAt(index)) {
            visited[k][j] = true;
            if (dfs(k, j, word, index + 1, visited, board)) {
                return true;
            }
            visited[k][j] = false;
        }
        if (l < board.length && !visited[l][j] && board[l][j] == word.charAt(index)) {
            visited[l][j] = true;
            if (dfs(l, j, word, index + 1, visited, board)) {
                return true;
            }

            visited[l][j] = false;
        }
        if (m >= 0 && m < board[i].length && !visited[i][m] && board[i][m] == word.charAt(index)) {
            visited[i][m] = true;

            if (dfs(i, m, word, index + 1, visited, board)) {
                return true;
            }

            visited[i][m] = false;
        }
        if (n >= 0 && !visited[i][n] && board[i][n] == word.charAt(index)) {
            visited[i][n] = true;

            if (dfs(i, n, word, index + 1, visited, board)) {
                return true;
            }

            visited[i][n] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(exist(board, "SEE"));
    }
}
