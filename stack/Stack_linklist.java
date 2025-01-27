package com.dsa.javalearning.stack;

public class Stack_linklist {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class Stack{
            static Node head = null;
            public static boolean isEmpty (){
                return head==null;
            }

        //push
            public static void push(int data){
                Node newNode = new Node(data);
                newNode.next = head;
                head = newNode;
            }
            //pop
            public static int pop(){
                int top=head.data;
                head = head.next;
                return top;
            }
            public static void peak(){
                System.out.println(head.data);

            }
    }
    public static void main(String args[]){
        Stack s= new Stack();
        s.push(3);
        s.push(2);
        s.push(1);
        while(s.isEmpty()!=true){
            s.peak();
            s.pop();
        }
    }
}
