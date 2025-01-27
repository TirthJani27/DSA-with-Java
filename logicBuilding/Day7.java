package com.dsa.javalearning.logicBuilding;

import java.util.Scanner;

// Fibonacci detailed Recursion
// Is Two Tree Same
// Arrival of the General

public class Day7 {
    public static int fibo(int n){
        if(n<=1)
            return n;
        return fibo(n-1)+fibo(n-2);

    }
    public static int generalArrival(int[] arr){
        int minInd = -1;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int maxInd = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=min){
                min = arr[i];
                minInd = i;
            }
        }
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>=max){
                max = arr[i];
                maxInd = i;
            }
        }
        if(maxInd > minInd){
            return maxInd + arr.length - minInd - 2;
        }
        return maxInd + arr.length - minInd - 1;
    }
    public static void main(String[] args) {
        System.out.println(fibo(4));
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i]=in.nextInt();
//        }
//        System.out.println(generalArrival(arr));
    }
}
