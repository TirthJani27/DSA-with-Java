package com.dsa.javalearning.logicBuilding;

import java.util.*;

//  Search in Rotated Sorted Array
//  Doremy's Paint 3 [Code-Forces : 1890-A]

public class Day5 {
    public static boolean doremyCheck(int[] arr){
        HashMap<Integer,Integer> hs = new HashMap<>();
        for (int curr : arr) {
            if (!hs.containsKey(curr)) {
                hs.put(curr, 1);
            } else {
                hs.replace(curr, hs.get(curr) + 1);
            }
        }
        if(hs.size() == 1){
            return true;
        }else if(hs.size() == 2){
            int v1= 0;
            int v2= 0;
            int i=0;
            for (HashMap.Entry<Integer, Integer> entry : hs.entrySet()) {
                Integer value = entry.getValue();
                if(i==0){
                    v1 = value;
                }else{
                    v2 = value;
                }
                i++;
            }
            if(Math.abs(v1-v2)<2){
                return true;
            }
        }
        return false;
    }
    public static int search(int[] arr, int tar){
        int f = arr.length-1;
        int b = 0;
        int ans = -1;
        while(f>=b){
            int mid = (f + b)/2;
            if(arr[mid] == tar){
                ans = mid;
            }
            if(arr[b] <= arr[mid]){
                //check if it is sorted part
                if(tar >= arr[b] && tar <= arr[mid]){
                    f = mid-1;
                }else{
                    b = mid+1;
                }
            }else{
                if(tar <= arr[f] && tar >= arr[mid]){
                    b = mid+1;
                }else{
                    f = mid-1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
//        int[] arr = { 5,1,3};
//        System.out.println(search(arr,3));
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int j =0 ;
        while(j<=tc){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int i = 0;
            while(i<n){
                arr[i] = sc.nextInt();
                i++;
            }
            System.out.println(doremyCheck(arr));
            j++;
        }
    }
}