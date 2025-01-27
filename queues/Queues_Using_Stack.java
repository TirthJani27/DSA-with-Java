package com.dsa.javalearning.queues;
import java.util.Stack;
public class Queues_Using_Stack {
    static class Queues{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();
        public static void add(int data){
            while(!s1.isEmpty()){
                int i=s1.pop();
                s2.push(i);
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }

        }
        public static int remove(){
            if(s1.isEmpty()){
                return -1;
            }
            return s1.pop();
        }
        public static boolean isEmpty(){
            if(s1.isEmpty()){
                return true;
            }
            return false;
        }
        public static int peek(){
            if(s1.isEmpty()){
                return -1;
            }
            return s1.peek();

        }
    }
    public static void main(String args[]){
        Queues q = new Queues();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){

            System.out.println(q.peek());
            q.remove();
        }
    }
}
