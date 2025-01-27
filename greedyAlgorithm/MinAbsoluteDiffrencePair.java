package com.dsa.javalearning.greedyAlgorithm;
import java.util.*;
public class MinAbsoluteDiffrencePair {
    public static void main(String[] args) {
        int[] arr1={4,1,8,7};
        int[] arr2={2,3,6,5};
        System.out.print(minAbsolute(arr1,arr2));
    }
    public static int minAbsolute(int[] arr1,int [] arr2){
        Arrays.sort(arr1);
        int ans=0;
        Arrays.sort(arr2);
        for(int i=0;i<arr2.length;i++){
            if(arr2[i]>arr1[i]){
                ans=ans+(arr2[i]-arr1[i]);
            }else{
                ans=ans+(arr1[i]-arr2[i]);
            }
        }
        return ans;
    }
}
