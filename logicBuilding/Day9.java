package com.dsa.javalearning.logicBuilding;

import java.util.ArrayList;
import java.util.Scanner;
public class Day9 {
    // Print subsequence with given sum
    // Target Practice[Code Forces]
    public static void findSub(int idx, int sum, int tar, int[] arr, ArrayList<Integer> list){
       if(arr.length <= idx){
           if(tar == sum) {
               System.out.println(list);
           }
           return;
       }
       sum+=arr[idx];
       list.add(arr[idx]);
       findSub(idx+1,sum,tar,arr,list);
       sum-=arr[idx];
       list.removeLast();
       findSub(idx+1,sum,tar,arr,list);
    }

    public static int getScore(int x,int y){
        if( x==0 || x==9 ||y == 0 || y==9 ){
            return 1;
        }else if( x==1 || x==8 ||y == 1 || y==8 ){
            return 2;
        }
        else if( x==2 || x== 7 ||y == 2 || y==7 ){
            return 3;
        }
        else if( x==3 || x== 6 ||y == 3 || y==6 ){
            return 4;
        }
        return 5;
    }
    public static int scorePridicter(String[] board){
        int ans = 0;
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length();j++){
                if(board[i].charAt(j) == 'X'){
                    ans+=getScore(i,j);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        findSub(0,0,5,arr,new ArrayList<>());
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int i = 0;
        while(i<tc){
            String[] board = new String[10];
            for (int j = 0; j <10; j++) {
                board[j] = sc.next();
            }
            System.out.println(scorePridicter(board));
            i++;
        }
    }
}
