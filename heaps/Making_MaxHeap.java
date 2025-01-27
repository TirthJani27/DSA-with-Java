package com.dsa.javalearning.heaps;

public class Making_MaxHeap {
    static class MaxHeap{
        int[] a;
        int capacity;
        int n=0;
        MaxHeap(int capacity){
            this.capacity=capacity;
            a=new int[capacity+1];
        }
        private void swap(int k,int b){
            int temp=a[k];
            a[k]=a[b];
            a[b]=temp;
        }
        void insert(int key)throws Exception{
            if(n == capacity+1) throw new Exception("Heap Overflow");
            n++;
            a[n]=key;
            int i=n;
            while(i>1){
                if(a[i]>a[i/2]){
                    swap(i,i/2);
                    i=i/2;
                }else{
                    return;
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
        void extractMax() {
            a[1]=a[n];
            n--;
            int i=1;
            while(i<=n){
                int small=i;
                //left > right
                if((i*2) <= n && a[i*2]>a[i]){
                    swap(i*2,i);
                    i=i*2;
                }
                else if((i*2)+1 <= n && a[(i*2)+1]>a[i]){

                    swap((i*2)+1,i);
                    i=(i*2)+1;
                }
                else{
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        MaxHeap mh=new MaxHeap(5);
        mh.insert(5);
        mh.insert(4);
        mh.insert(6);
        mh.insert(8);
        mh.insert(10);
        mh.print();
        System.out.println();
        System.out.print(mh.peek());
        mh.extractMax();
        System.out.println();
        mh.print();
        mh.extractMax();
        System.out.println();
        mh.print();
        mh.extractMax();
        System.out.println();
        mh.print();
    }
}
