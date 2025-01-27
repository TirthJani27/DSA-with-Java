package com.dsa.javalearning.queues;

public class Circular_Queues_ {
    static class Queue{
        static int size;
        static int arr[];
        static int  rear;
        static int front;
        Queue(int n){
            arr  = new int [n];
            size = n;
            rear = -1;
            front = -1;
        }
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }
        public static boolean isFull(){
            return (rear+1)%size==front;
        }
        public static void add(int data){
            if(isFull()){
                System.out.println("Queues is full");
                return;
            }else{

                if(front==-1){
                    front=0;
                }
                rear=(rear + 1)%size;
                arr[rear]=data;
            }
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queues is empty");
                return -1;
            }
            int result=arr[front];
            if(front==rear){
                rear=front=-1;
            }else {
                front = (front + 1) % size;
            }
            return result;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queues is Empty");
                return -1;
            }
            return arr[0];
        }
    }
    public static void main(String arsg[]){
        Making_queues_using_array.Queue q = new Making_queues_using_array.Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
