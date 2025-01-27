package com.dsa.javalearning.heaps;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Make_priorityQuese{
    static class Std implements Comparable<Std>{
        int rank;
        String name;
        Std(String name,int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Std s2){
            return s2.rank-this.rank;
        }
    }
    public static void main(String[] args) {
        Std s1 = new Std("Chagan",100);
        Std s2 = new Std("Magan",1000);
        Std s3 = new Std("Chintan",1040);
        Std s4 = new Std("Chiman",101);
        Std s5 = new Std("Chirag",12);
        PriorityQueue<Std> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(s1);
        pq.add(s2);
        pq.add(s3);
        pq.add(s4);
        pq.add(s5);
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+" "+pq.peek().rank);
            pq.remove();
        }
    }
}
