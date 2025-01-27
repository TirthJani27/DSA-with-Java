package com.dsa.javalearning.logicBuilding;

import java.util.ArrayList;
import java.util.Scanner;

public class Day11 {
    // Do not try to count[Codeforces]
    // Subsets Sum I[Leetcode]

    public static void subsetSum(int[] arr, int ind, int sum, ArrayList<Integer> list){
        if(ind >= arr.length){
            return;
        }
        sum+=arr[ind];
        list.add(sum);
        subsetSum(arr,ind+1,sum,list);
        sum-=arr[ind];
        subsetSum(arr,ind+1,sum,list);
    }

    public static int doNotTryToCount(String sub,String string){
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while(sb.length()<string.length()){
            ans++;
            sb.append(sub);
            sub = sb.toString();
        }
        int temp =0;
        for(int i=0;i<sub.length();i++){
            if(sub.charAt(i) == string.charAt(0) && i+string.length()< sb.length()){
                int temp1 = i;
                while(temp1<i+string.length()){
                    if(sub.charAt(temp1) != sb.charAt(temp)){
                        break;
                    }
                    temp++;
                    temp1++;
                }
                if(temp == string.length()+1){
                    return ans;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long m = scanner.nextLong();
            long cnt = 6;
            long f = 0;
            long res = 0;
            String x = scanner.next();
            String s = scanner.next();

            while (cnt-- > 0) {
                if (x.indexOf(s) != -1) {
                    f = 1;
                    break;
                }
                res++;
                x += x;
            }

            if (f == 1)
                System.out.println(res);
            else
                System.out.println(-1);
        }
    }


//        int[] arr = {1,2,3};
//        int[] ans = new int [(int) Math.pow(2,arr.length)];
//        ArrayList<Integer> ansL = new ArrayList<>();
//        subsetSum(arr,0,0,ansL);
//        for (int i = 0; i < ansL.size(); i++) {
//            ans[i+1] = ansL.get(i);
//        }
//        Arrays.sort(ans);
//        for (int i = 0; i < ans.length; i++) {
//            System.out.print(ans[i]+" ");
//        }

}
