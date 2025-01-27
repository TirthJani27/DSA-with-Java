package com.dsa.javalearning.queues;
public class Making_queues_using_array {
    static class Queue{
        static int size;
        static int arr[];
        static int  rear;
        Queue(int n){
            arr  = new int [n];
            size = n;
            rear = -1;
        }
        public static boolean isEmpty() {
            return rear == -1;
        }
        public static void add(int data){
         if(rear==size-1){
             System.out.println("Queues is full");
             return;
         }else{
             rear=rear + 1;
             arr[rear]=data;
         }
        }
         public static int remove(){
             if(isEmpty()){
                 System.out.println("Queues is empty");
                 return -1;
             }
                int frount=arr[0] ;
                for(int i=0;i<rear;i++){
                    arr[i]=arr[i+1];
                }
                rear= rear-1;
                return frount;
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
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}