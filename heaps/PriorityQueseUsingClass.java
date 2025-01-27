package com.dsa.javalearning.heaps;
import java.util.PriorityQueue;
public class PriorityQueseUsingClass {
    static class Student implements Comparable<Student>{
        int rank;
        String name;
        public Student(String name,int rank){
            this.rank=rank;
            this.name=name;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A",12));
        pq.add(new Student("B",11));
        pq.add(new Student("C",10));
        pq.add(new Student("D",13));
        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            pq.remove();
        }
    }
}
