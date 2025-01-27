package com.dsa.javalearning.queues;

public class Linklist_Queues {
    static class Node{
        int data;
        Node next;
        Node(int data) {
            this.data=data;
            this.next=null;
            }
        }
        static class Queuesll{
        static Node head=null;
        static Node tail=null;
        public static boolean isEmpty() {
            return  head==null || tail==null;
        }
        public static void add(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queues");
                return -1;
            }
            int front = head.data;
            head=head.next;
            return front;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            if(head==null){
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String arsg[]){
        Queuesll q = new Queuesll();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }

}
