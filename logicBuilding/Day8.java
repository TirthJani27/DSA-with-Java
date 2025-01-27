package com.dsa.javalearning.logicBuilding;

import java.util.ArrayList;
import java.util.Scanner;
public class Day8 {
    // All possible subsequence
    // Game with Integers[Code Forces]
    // Count Good Numbers[Leetcode]
    public static int countGoodNumber(long n,long i,int ans){
        if(i >= n)
            return ans;
        if(i%2 == 0){
            ans*=5;
        }else{
            ans*=4;
        }
        ans %= Integer.MAX_VALUE;
        if(ans == 0){
            ans = 1;
        }
        return countGoodNumber(n,i+1,ans);
    }
    public static void subSequence(int[] arr,int i,ArrayList<Integer> ans){

        if(i == arr.length){
            System.out.println(ans);
            return;
        }
        ans.add(arr[i]);
        subSequence(arr,i+1,ans);
        ans.removeLast();
        subSequence(arr,i+1,ans);
    }
    public static void main(String[] args) {
        // Game with Integers
//        Scanner sc = new Scanner(System.in);
//        int tc = sc.nextInt();
//        while(tc>0){
//            int a = sc.nextInt();
//            if(a%3 == 0)
//                System.out.println("Second");
//            else
//               System.out.println("First");
//            tc--;
//        }
        // Subsequence
        int[] arr = {1,2,3};
        ArrayList<Integer> ans =new ArrayList<>();
        subSequence(arr,0,ans);

        // Count Good Numbers
//        long n = 100;
//        int ans = 1;
//        System.out.println(countGoodNumber(n,0,ans));
    }
}
