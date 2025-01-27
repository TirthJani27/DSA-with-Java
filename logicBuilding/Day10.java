package com.dsa.javalearning.logicBuilding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day10 {
    // Combination Sum
    // Balanced Round
    public static void rec(int ind,int tar,int[] arr,List<List<Integer>> ans,List<Integer> list){
        if(ind == arr.length){
            if(tar == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[ind]<=tar){
            list.add(arr[ind]);
            rec(ind,tar-arr[ind],arr,ans,list);
            list.removeLast();
        }
        rec(ind+1,tar,arr,ans,list);
    }
    public static List<List<Integer>> combinationSum(int[] arr, int tar){
        List<List<Integer>> ans = new ArrayList<>();
        rec(0,tar,arr,ans,new ArrayList<>());
        return ans;
    }
    public static int balancedRound(int[] arr,int k){
        int temp = 1;
        int ans = 0;
        if(arr.length == 1){
            return 0;
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]<=k){
                temp++;
            }else{
                temp=1;
            }
                ans = Math.max(temp,ans);
        }
        return arr.length-ans;
    }
    public static void main(String[] args) {
//        int[] arr = {2,3,6,7};
//        int tar = 7;
//        System.out.println(combinationSum(arr,tar));
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int i=0;
        while (i<tc){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            System.out.println(balancedRound(arr,k));
            tc--;
        }
    }
}
