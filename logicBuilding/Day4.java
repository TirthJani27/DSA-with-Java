package com.dsa.javalearning.logicBuilding;

import java.util.Scanner;

// A. Goals of Victory [code: 1877 A]
public class Day4 {
public static int day4Sol(int[] arr){
    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
        ans = ans + arr[i];
    }
    return -ans;
}
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int i = 0;
        while(i<tc){
            int n = sc.nextInt();
            int[] arr = new int [n-1];
            for (int j = 0; j < n-1; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(day4Sol(arr));
            i++;
        }
    }

    //Longest Palindrome
    public static String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");
        StringBuilder ans = new StringBuilder("");
        if(s.length() == 1){
            return s;
        }
        if (s.length() % 2 != 0) {
            for (int i = 1; i < s.length(); i++) {
                int b = i - 1;
                int f = i + 1;
                sb = new StringBuilder("");
                sb.append(s.charAt(i));
                while (b > -1 && f < s.length()) {
                    if (s.charAt(b) == s.charAt(f)) {
                        sb = new StringBuilder(s.substring(b, f + 1));
                        b--;
                        f++;
                    } else
                        break;
                }
                if (sb.length() > ans.length()) {
                    ans = sb;
                }
            }
        }else{
            //abba
            for (int i = 1; i < s.length()-1; i++) {
                char curr = s.charAt(i);
                if(curr == s.charAt(i+1)){
                    sb.append(curr);
                    sb.append(curr);
                    int f = i+2;
                    int b = i-1;
                    while(b>-1 && f<s.length()){
                        if(s.charAt(b) == s.charAt(f)){
                            sb = new StringBuilder(s.substring(b, f + 1));
                            b--;
                            f++;
                        }else
                            break;
                    }
                    if (sb.length() > ans.length()) {
                        ans = sb;
                    }
                }
            }
        }
        return ans.toString();
    }
}
