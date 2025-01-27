package com.dsa.javalearning.logicBuilding;

import java.util.ArrayList;
import java.util.Scanner;

public class Day13 {
    // All Permutation Possible of Array
    // Everybody Likes Good Arrays! [1777 - A]
    public static int goodArray(int[] arr){
        int temp = 0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]%2 == arr[i+1]%2){
                temp++;
            }
        }
        return temp;
    }
    public static void helper(int[] arr,ArrayList<Integer> ds,ArrayList<ArrayList<Integer>> ans,boolean[] flags){
        if(ds.size() == arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!flags[i]){
                ds.add(arr[i]);
                flags[i]=true;
                helper(arr,ds,ans,flags);
                ds.removeLast();
                flags[i]=false;
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> permutation(int[] arr){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        helper(arr,new ArrayList<>(),ans,new boolean[arr.length]);
        return ans;
    }
    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        System.out.println(permutation(arr));
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc>0){
            int n = sc.nextInt();
            int[] arr = new int [n];
            for(int i=0;i<n;i++){
                arr[i] =sc.nextInt();
            }
            System.out.println(goodArray(arr));
            tc--;
        }
    }
}
