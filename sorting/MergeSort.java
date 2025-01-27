package com.dsa.javalearning.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 18, 19, 10, 5, 6322, 63};
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    public static void mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = (si + ei) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, ei, mid);
    }

    public static void merge(int[] arr, int si, int ei, int mid) {
        int k = 0;
        int i = si;
        int j = mid + 1;
        int[] temp = new int[ei - si + 1];
        while (i <= mid && j <= ei) {
            if (arr[i] > arr[j]) {
                temp[k] = arr[j];
                j++;
            } else {
                temp[k] = arr[i];
                i++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= ei) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (i = si ,k=0; k < temp.length; i++,k++) {
            arr[i] = temp[k];
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
