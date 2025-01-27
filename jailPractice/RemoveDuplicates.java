package com.dsa.javalearning.jailPractice;

public class RemoveDuplicates {
    public static void removeDuplicates(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int j = i+1;
            while(arr[i] == arr[j]){
               arr[j] = 0;
               j++;
            }
            i=j-1;
        }
        int k = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != 0){
                arr[k] = arr[i];
                k++;
            }
        }
        for (int i = k+1; i < arr.length; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr  = {1,1,1,1,2,2,3,3,3,4,4,5,5,6,6,6,9};
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
        removeDuplicates(arr);
    }
}
