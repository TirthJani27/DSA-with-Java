import java.util.*;

public class SurroundedRegions {
    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solve(char[][] board) {
        Queue<Pair> q = new ArrayDeque<>();
        ArrayList<Pair> helper = new ArrayList<>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        int[][] help = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                q.add(new Pair(i, 0));
                vis[i][0] = true;
            }
            if (board[i][board[0].length - 1] == 'O' && !vis[i][board[0].length - 1]) {
                q.add(new Pair(i, board[0].length - 1));
                vis[i][board[0].length - 1] = true;
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O' && !vis[0][j]) {
                q.add(new Pair(0, j));
                vis[0][j] = true;
            }
            if (board[board.length - 1][j] == 'O' && !vis[board.length - 1][j]) {
                q.add(new Pair(board.length - 1, j));
                vis[board.length - 1][j] = true;
            }
        }

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            for (int k = 0; k < help.length; k++) {
                int currX = help[k][0] + x;
                int currY = help[k][1] + y;
                if (currX >= 0 && currX < vis.length && currY >= 0 && currY < vis[0].length
                        && !vis[currX][currY] && board[currX][currY] == 'O') {
                    q.add(new Pair(currX, currY));
                    vis[currX][currY] = true;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };
        printBoard(board);
        solve(board);
    }
}
