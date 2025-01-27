package com.dsa.javalearning.queues;
import java.util.Queue;
import java.util.LinkedList;
public class Half_Queues {
    public static void halfQueues(Queue<Integer> q) {
        Queue<Integer> firsthalf = new LinkedList<>();
        int sizeHalf = q.size() / 2;
        for (int i = 0; i < sizeHalf; i++) {
            firsthalf.add(q.remove());
        }
            while (!firsthalf.isEmpty()) {
                int top = q.remove();
                q.add(firsthalf.remove());
                q.add(top);
            }
        }
    public static void main(String args[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        halfQueues(q);
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
