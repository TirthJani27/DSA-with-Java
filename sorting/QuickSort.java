package com.dsa.javalearning.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 18, 19, 10, 5, 6322, -3};
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
    static void quickSort(int arr[],int si,int ei){
        if(si<ei){
            int pindx=partition(arr,si,ei);
            quickSort(arr,si,pindx-1);
            quickSort(arr,pindx+1,ei);
        }
    }
    static int partition(int arr[],int si,int ei){
        int p = arr[ei];
        int i=-1;
        for (int j = 0; j <= ei; j++) {
            if(arr[j]<p){
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = p;
        arr[ei] = temp;
        return i;
    }
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
