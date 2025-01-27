package com.dsa.javalearning.logicBuilding;

import java.util.Arrays;
import java.util.Scanner;

public class Day14 {
    // Ambitious Kid
    // N Queens
    public static int ambitiousKid(int[] arr,int n){
        for (int i = 0; i < n; i++) {
            if(arr[i]<0){
                arr[i]*=-1;
            }
        }
        Arrays.sort(arr);
        return arr[0];
    }
    public static boolean isSafe(int i,int j,char[][] board){
        //Slant And Straight
        for (int k = 0; k < j; k++) {
            if(board[i][k] == 'Q') return false;
        }
        int n = board.length;
        int ti = i;
        int tj = j;
        //Zig Zac
        while(ti>-1 && tj>-1){
            if(board[ti][tj] == 'Q') return false;
            ti--;
            tj--;
        }
        ti = i;tj = j;
        while(ti>=0 && tj<n){
            if(board[ti][tj] == 'Q') return false;
            ti--;
            tj++;
        }ti = i;tj = j;
        while(ti<n && tj>=0){
            if(board[ti][tj] == 'Q') return false;
            ti++;
            tj--;
        }
        return true;
    }
    public static void fillBoard(int n, int col, char[][] board){
        if(col>=n){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.print("-----");
            System.out.println();
            System.out.println();
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(i,col,board)){
                board[i][col]='Q';
                fillBoard(n,col+1,board);
                board[i][col]='.';
            }
        }
    }
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }
        fillBoard(n,0,board);
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//            for (int i = 0; i < n; i++) {
//                arr[i] = sc.nextInt();
//            }
//            System.out.println(ambitiousKid(arr,n));
    }
}
