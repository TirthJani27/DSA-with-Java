package com.dsa.javalearning.logicBuilding;

import java.util.Scanner;

public class Day3 {
    // Maximum Product of sub array
    public static int maxSub_arrayPro(int[] arr){
        int ans = Integer.MIN_VALUE;
        int temp  = 1;
        // Forward
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                if(0>ans){
                    ans=0;
                }
                else if(temp>ans){
                    ans = temp;
                }
                temp = 1;
            }else{
                temp *= arr[i];
                if(temp>ans){
                    ans=temp;
                }
            }
        }
        // Backward
        temp = 1;
        for (int i = arr.length-1; i > -1; i--) {
            if(arr[i] == 0){
                if(0 >= ans){
                    ans=0;
                }
                else if(temp>ans){
                    ans = temp;
                }
                temp = 1;
            }else{
                temp *= arr[i];
                if(temp>ans){
                    ans=temp;
                }
            }
        }
        return ans;
    }
    //Jagged Swaps
    public static String jaggedSwap(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[0]>arr[i]){
                return "NO";
            }
        }
        return "YES";
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        int i=1;
        while(i<=tc){
            int len = in.nextInt();
            int[] arr = new int[len];
            for(int j=0;j<arr.length;j++){
                arr[j]=in.nextInt();
            }
            System.out.println(jaggedSwap(arr));
            i++;
        }
    }
}