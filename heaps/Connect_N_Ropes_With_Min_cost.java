package com.dsa.javalearning.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class Connect_N_Ropes_With_Min_cost {
    public static long minCost(long[] a){
        Queue<Long> pq =new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
            pq.offer(a[i]);
        }
        long cost=0;
        while(!pq.isEmpty() && pq.size()>1){
                long x = pq.poll();
                long y = pq.poll();
                long c = x + y;
                cost+=c;
                pq.offer(c);
        }
        return cost;
    }
    public static void main(String[] args) {
        long[] a={4,2,6,3};
        System.out.println(minCost(a));
    }
}
