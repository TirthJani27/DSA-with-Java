package com.dsa.javalearning.queues;
import java.util.*;
public class Stack_using_Deques {
    static class Stacks{
        static Deque<Integer> deque = new LinkedList<>();
        public static void push(int data){
            deque.addLast(data);
        }
        public static int pop(){

            int top=deque.removeLast();
            return top;
        }
        public static void print(){
            System.out.println(deque);
        }
    }
    static class Queues{
        static Deque<Integer> deque1 = new LinkedList<>();
        public static void add(int data){
            deque1.addLast(data);
        }
        public static int remove(){

            int top=deque1.removeFirst();
            return top;
        }
        public static void print(){
            System.out.println(deque1);
        }
    }
    public static void main(String args[]){
        Queues q = new Queues();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.print();
        q.remove();
        q.print();
        Stacks s =new Stacks();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.print();
        s.pop();
        s.print();

    }
}
