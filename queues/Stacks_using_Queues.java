package com.dsa.javalearning.queues;
import java.util.LinkedList;
import java.util.Queue;
public class Stacks_using_Queues {
    static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();
        public static boolean isEmpty(){
            return q1.isEmpty()&& q2.isEmpty();
        }
        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }
        public static int pop(){

            int top=-1;
            if(q1.isEmpty()&& q2.isEmpty()){
                return top;
            }
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            } else{
                    while(!q2.isEmpty()){
                        top= q2.remove();
                        if(q2.isEmpty()){
                           break;
                        }
                        q1.add(top);
                    }
                }
            return top;
            }
        }

    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
