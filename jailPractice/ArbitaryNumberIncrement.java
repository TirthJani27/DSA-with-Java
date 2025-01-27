package com.dsa.javalearning.jailPractice;

public class ArbitaryNumberIncrement {
    public static void main(String[] args) {
        int[] arr = {9,9};
        int[] ayush =  increment(arr);
        for (int i = 0; i < ayush.length; i++) {
            System.out.print(ayush[i]+" ");
        }
    }
    public static int[] increment(int[] arr){
        int val= 0;
        int place = 1;
        for (int i = arr.length-1; i >= 0; i--) {
            val += arr[i] * place;
            place*=10;
        }
        val+=1;
        place = 10;
        int ans = val;
        int digit = 0;
        while(val > 0){
            val /= place;
            digit+=1;
        }
        int[] ansArr = new int[digit];
        place = 10;
        for (int i = digit-1; i >= 0; i--) {
            ansArr[i] = ans % place;
            ans = ans/place;
        }
        return ansArr;

    }
}
