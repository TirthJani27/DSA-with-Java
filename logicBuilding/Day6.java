package com.dsa.javalearning.logicBuilding;

import java.util.Scanner;
public class Day6 {
    // Basics of recursion(Recall the basics)
    // Matrix traversal in spiral
    // Cover In Water [Code Forces: 1900 A]



//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int tc = in.nextInt();
//        int i = 0;
//        while(i<tc){
//            int n = in.nextInt();
//            String arr = in.next();
//            System.out.println(coverInWater(arr));
//            i++;
//        }
//    }

    public static int sum1(int cnt){
        if(cnt == 1){
            return cnt;
        }
        return cnt*sum1(cnt-1);
    }
    public static void main(String[] args) {
        System.out.println(sum1(5));
    }

    public static int coverInWater(String s){
        int ans = 0;
        int i = 0;
        int temp = 0;
        while (i<s.length()){
            if(s.charAt(i) == '.'){
                temp++;
                if(temp == 3){
                    return 2;
                }
            }else{
                ans+=temp;
                temp = 0;
            }
            i++;
        }
        if(temp < 3){
            ans += temp;
        }
        return ans;
    }
}