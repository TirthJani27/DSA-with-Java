package com.dsa.javalearning.jailPractice;

public class AdvancingThroughAnArray {
    public static boolean isPossible(int[] arr) {
        int recentCount = 0;
        for (int i = arr.length - 1; i > -1; i--) {
            while (arr[i] == 0) {
                recentCount++;
                i--;
            }
            while (i >= 0 && arr[i] <= recentCount) {
                recentCount++;
                i--;
            }
            if (i == -1) {
                return false;
            }
            recentCount = 0;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 0, 0, 2, 3};
        boolean a = isPossible(arr);
        System.out.println(a);
    }
}