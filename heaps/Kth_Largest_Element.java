package com.dsa.javalearning.heaps;

import java.util.*;

public class Kth_Largest_Element {
    public static ArrayList<Integer> kLargest(int a[], int n, int k)
    {
        // code here
        Queue<Integer> pq =new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.offer(a[i]);
        }
        for(int i=k;i<n;i++){
            if(pq.peek()<a[i]){
                System.out.println(pq);
                pq.remove();
                pq.offer(a[i]);
            }
        }
        ArrayList<Integer> ans =new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a={12, 5 ,787 ,1 ,23};
        System.out.println(kLargest(a,a.length,2));
    }
}
