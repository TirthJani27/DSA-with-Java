package com.dsa.javalearning.logicBuilding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day16 {
    // String Partitioning [Leetcode]
    // 
    public static List<List<String>> partition(String s){
        List<List<String>> res = new ArrayList<>();
        helper(0,s,new ArrayList<>(),res);
        return res;
    }
    public static void helper(int index,String s,List<String> ds,List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if(isPalindrome(s,index,i)){
                ds.add(s.substring(index,i+1));
                helper(i+1,s,ds,ans);
                ds.removeLast();
            }
        }
    }
    public static boolean isPalindrome(String s,int st,int en){
        while(st<=en){
            if(s.charAt(st++) != s.charAt(en--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
//        System.out.println(partition("AAB"));
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc>0){
            int x = sc.nextInt();
            int k = sc.nextInt();
            if(x%k==0){
                System.out.println(2);
                System.out.print(x-1+" ");
                System.out.println(1);
            }else{
                System.out.println(1);
                System.out.println(x);
            }
            tc--;
        }
    }
}
