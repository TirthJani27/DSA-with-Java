package com.dsa.javalearning.logicBuilding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day12 {
    // Array Coloring codeforces
    // Subset sum II [Leetcode]

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] arr){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subsetRecursion(0,arr,new ArrayList<>(),ans);
        return ans;
    }
    public static void subsetRecursion(int ind,int[] arr,ArrayList<Integer> ds,ArrayList<ArrayList<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for (int i = ind; i < arr.length; i++) {
            if(i!=ind && arr[i] == arr[i-1])continue;
            ds.add(arr[i]);
            subsetRecursion(i+1,arr,ds,ans);
            ds.removeLast();
        }
    }
    public static boolean arrayColoring(int[]arr){
        int temp = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] % 2!=0){
                temp++;
            }
        }
        return temp % 2 == 0;
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int tc = sc.nextInt();
//        while(tc>0){
//            int n = sc.nextInt();
//            int[] arr = new int[n];
//            for (int i = 0; i < n; i++) {
//                arr[i] = sc.nextInt();
//            }
//            if(arrayColoring(arr)){
//                System.out.println("Yes");
//            }else{
//                System.out.println("No");
//            }
//            tc--;
//        }
        int[] arr = {1,2,3,3};
        System.out.println(subsetsWithDup(arr));
    }
}
