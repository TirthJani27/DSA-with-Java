package com.dsa.javalearning.jailPractice;

public class DutchFlag {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,2,2,1,2,1,2,1,2,1,2,0,0};
        dutchFlag(arr);
        for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]+" ");
        }
    }
    public static void dutchFlag(int []arr){
        int zeroInd = 0;
        int twoInd = arr.length-1;
        int curr = 0;
//            int i = arr.length-1;
//        while(arr[i] == 2 ){
//            twoInd-=1;
//            i--;
//        }
//        i=0;
//        while(arr[i] == 0 ){
//            zeroInd+=1;
//            i++;
//        }
        while( curr<=twoInd){

            if(arr[curr] == 2 ){
                int temp = arr[curr];
                arr[curr] = arr[twoInd];
                arr[twoInd] = temp;
                twoInd--;
            }else if(arr[curr] == 0){
                int temp = arr[curr];
                arr[curr] = arr[zeroInd];
                arr[zeroInd] = temp;
                zeroInd++;
                curr++;
            }else {
                curr++;
            }
        }
    }
}
