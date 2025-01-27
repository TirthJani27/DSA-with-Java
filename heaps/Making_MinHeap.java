package com.dsa.javalearning.heaps;

public class Making_MinHeap {
    static class MinHeaps{
        int[] a;
        int capacity;
        int n=0;
        MinHeaps(int capacity){
            this.capacity=capacity;
            a=new int[capacity+1];
        }
        private void swap(int k,int b){
            int temp=a[k];
            a[k]=a[b];
            a[b]=temp;
        }
        void insert(int key)throws Exception{
            if(n+1 > capacity) throw new Exception("Heap is Full");
            n++;
            a[n]=key;
            int i=n;
            while(i>1) {
                int parent = i / 2;
                if (a[parent] > a[i]) {
                    swap(parent, i);
                    i=parent;
                }
                else{
                    break;
                }
            }
        }
        void print(){
            for (int i=1;i<=n;i++) {
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }
        int peek(){
            return a[1];
        }
        void extractMin(){
            a[1]=a[n];
            n--;
            int i=1;
            while(i<n){
                //if left < right
                if(a[i*2]<a[(i*2)+1]){
                    swap(i*2,i);
                    i=i*2;
                }else{
                    swap((i*2)+1,i);
                    i=(i*2)+1;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        MinHeaps mh = new MinHeaps(6);
        mh.insert(5);
        mh.insert(4);
        mh.insert(8);
        mh.insert(1);
        mh.insert(10);
        mh.print();
        System.out.println(mh.peek());
        System.out.println();
        mh.extractMin();
        mh.print();
        mh.extractMin();
        mh.print();
    }
}
