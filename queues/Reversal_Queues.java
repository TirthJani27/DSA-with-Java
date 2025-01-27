package com.dsa.javalearning.queues;
import java.util.*;
public class Reversal_Queues {
    public static void reversalQueue(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        int  size = q.size();
        for(int i=0;i<size;i++){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String args[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        reversalQueue(q);
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
