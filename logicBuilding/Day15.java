package com.dsa.javalearning.logicBuilding;

public class Day15 {
    // Sudoku Solver
    // Unit Array
    public static int unitArray(int[] array){
        int i = 0;
        return i;
    }
    public static boolean isSafe(int[][] board,int x,int y,int val){
        for(int i=0;i<9;i++){
            if(board[x][i] == val){
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if(board[i][y] == val){
                return false;
            }
        }
        int si = (x/3) *3;
        int sj = (y/3) *3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[si+i][sj+j] == val){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int board[][]){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == 0){
                    for (int k = 1; k < 10; k++) {
                        if(isSafe(board,i,j,k)){
                            board[i][j] = k;
                            if(sudokuSolver(board)){
                                return true;
                            }else{
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        sudokuSolver(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }
}
