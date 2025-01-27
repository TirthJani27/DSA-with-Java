package com.dsa.javalearning.jailPractice;

public class MultiplicationProblem {
    public static void multiply(int[] a1, int[] a2 ){
        boolean flag = false;

        int[] ans = new int[a1.length+a2.length];
        int index = ans.length-1;
        int m = 0;
        for (int i = a2.length-1; i >=0; i--) {
            int carry = 0;
            for (int j = a1.length-1; j >= 0 ; j--) {
                int mul = (a2[i] * a1[j])+carry;
                int temp = mul;
                ans[index] += temp;
                index--;
            }
            ++m;
            index = ans.length-m-1;
        }
        int i = ans.length-1;
        int carry = 0;
        while(i>-1){
            if(ans[i]>9||carry>0){
                ans[i] = ans[i]+carry;
                carry = ans[i]/10;
                ans[i] = ans[i]%10;
            }
            i--;
        }
        for (i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }
    public static void main(String[] args) {
        int[] a1 = {1,9,3,7,0,7,7,2,1};
        int[] a2 = {-7,6,1,8,3,8,2,5,7,2,8,7};
         multiply(a1,a2);

    }
}
