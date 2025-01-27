package com.dsa.javalearning.greedyAlgorithm;

import java.util.*;
public class MaxStockPrice {
    static class Pair implements Comparable<Pair>{
        int p;
        int l;
        Pair(int p,int l) {
            this.p = p;
            this.l = l;
        }
        public int compareTo(Pair that) {

            return this.p - that.p;
        }
    }
    public static int buyMaximumProducts(int n, int k, int[] price) {
        int amount = k;
        int ans = 0;
        List<Pair> parr = new ArrayList<Pair>();
        for (int i = 0; i < n; i++) {
            parr.add(new Pair(price[i],i));
        }
        for (Pair curr: parr) {
            System.out.println(curr.p);
        }

//        for(int i=n-1; i>-1 ; i--){
//            while(amount>price[i]){
//                amount-=price[i];
//                ans++;
//            }
//        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {10,7,19};
        buyMaximumProducts(arr.length,45,arr);
    }
}
