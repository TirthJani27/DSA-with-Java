package com.dsa.javalearning.heaps;

public class HeapSort {
    static class Heaps {
        int[] a;
        int capacity;
        int n;

        Heaps(int[] a) {
            this.a = a;
            capacity = a.length - 1;
            n = a.length - 1;
            buildHeap();
        }

        void swap(int k, int b) {
            int temp = a[k];
            a[k] = a[b];
            a[b] = temp;
        }

        void heapify(int i) {
            while (i <= n) {
                int small = i;
                int l = i * 2;
                int r = i * 2 + 1;
                if (l <= n && a[l] < a[small]) {
                    small = l;
                }
                if (r <= n && a[r] < a[small]) {
                    small = r;
                } else {
                    if (i != small) {
                        swap(small,i);
                        i=small;
                    }else return;

                }
            }
        }
        void buildHeap() {
            for (int i = n/2; i >= 0; i--) {
                heapify(i);
            }
        }
        int extractMin(){
            int k = a[1];
            if(n<=1){
                return k;
            }
            a[1]=a[n];
            n--;
            int i=1;
            while(i<=n){
                int l=i*2;
                int r=i*2+1;
                int small=i;
                if(l<=n && a[l]<a[small]){
                    small=l;
                }
                if(r<=n && a[r]<a[small]){
                    small=r;
                }
                if(small!=i){
                    swap(small,i);
                    i=small;
                }else {
                    break;
                }
            }
            return k;
        }
        void heapSort(){
            int newN=n;
            for (int i=1;i<=newN;i++){
                System.out.print(extractMin()+" ");
            }
        }

        void printHeap(){
            for (int i = 1; i < a.length ; i++) {
                System.out.print(a[i]+" ");
            }
        }
    }



    public static void main(String[] args) {
        int[] a={0,19,2,17,1,6,8};
        Heaps mh=new Heaps(a);
        mh.printHeap();
        System.out.println();
        mh.heapSort();

    }
}
