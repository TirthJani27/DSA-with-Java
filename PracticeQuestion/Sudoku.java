public class Sudoku {
    static boolean isSafe(int a[][],int row,int col,int val) {
        // add your code here
        int i = 0;
        int j = 0;
        for (i = 0; i < 9; i++) {
            if (a[i][col] == val) {
                return false;
            }
        }
        for (j = 0; j < 9; j++) {
            if (a[row][j] == val) {
                return false;
            }
            if (a[3*(row/3)+i/3][3*(col/3)+i%3]==val) {
                return false;
            }
        }
        return true;
    }

    //Function to print grids of the Sudoku.
    static void print(int a[][]){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean SolveSudoku (int a[][])
    {
        int row=0;
        int col=0;
        for(row=0;row<9;row++){
            for(col=0;col<9;col++){
                if(a[row][col]==0){
                    for(int val=1;val<=9;val++){
                        if(isSafe(a,row,col,val)){
                            a[row][col]=val;
                            boolean agadSolution=SolveSudoku(a);
                            if(agadSolution){
                                return true;
                            }else{
                                a[row][col]=0;
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
        int grid[][] =
                {{3, 0, 6 ,5 ,0 ,8 ,4 ,0, 0},
                {5 ,2 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
                {0 ,8, 7, 0, 0 ,0 ,0, 3, 1 },
                {0, 0, 3 ,0, 1, 0, 0 ,8 ,0},
                {9 ,0 ,0, 8, 6 ,3, 0, 0, 5},
                {0, 5, 0 ,0 ,9, 0, 6 ,0 ,0},
                {1 ,3, 0, 0, 0, 0, 2 ,5 ,0},
                {0, 0, 0 ,0 ,0 ,0 ,0 ,7 ,4},
                {0, 0 ,5 ,2 ,0, 6,3, 0 ,0}};
        SolveSudoku(grid);
        print(grid);
    }
}
