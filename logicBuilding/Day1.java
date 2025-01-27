package com.dsa.javalearning.logicBuilding;

public class Day1 {
    public static int maxSubArrayWithNoAdjacentElementEvenOrOdd(int[] arr) {
        int ans = arr[0];
        int temp = arr[0];
        int i = 1;
        while(i<arr.length-1){
            if(arr[i] % 2 == arr[i-1]%2){
                temp=arr[i+1];
            }else{
                temp = Math.max(arr[i], temp+arr[i]);
            }
            ans = Math.max(ans,temp);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,-2,5,3,5,};
        System.out.println(maxSubArrayWithNoAdjacentElementEvenOrOdd(arr));
    }
}
