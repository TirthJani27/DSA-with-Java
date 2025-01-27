package com.dsa.javalearning.logicBuilding;

import java.util.*;

// Halloumi's Boxes Problem at CodeForces

public class Day2 {
    public static boolean hallomiBox(int[] arr,int k){
        if(k>=2){
            return true;
        }else{
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]){
                    return false;
                }
            }
        }
        return true;
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length], post = new int[nums.length], pre = new int[nums.length];
        int pref = 1;
        int postf = nums[nums.length - 1];
        pre[0] = 1;
        post[nums.length-1] = nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            pref = nums[i] * pref;
            pre[i] = pref;
        }
        for(int i=nums.length-2 ;i > -1; i--){
            postf = postf*nums[i];
            post[i] = postf;
        }
        ans[0] = post[0];
        ans[nums.length-1] = post[nums.length-1];
        for(int i = 1; i < nums.length-1;i++){
            ans[i]=post[i+1]*pre[i-1];
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        int i=1;
        while(i<=tc){
            int len = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[len];
            for(int j=0;j<arr.length;j++){
                arr[j]=in.nextInt();
            }
            if(hallomiBox(arr,k)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            i++;
        }
    }
}
