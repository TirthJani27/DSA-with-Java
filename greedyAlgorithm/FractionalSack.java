package com.dsa.javalearning.greedyAlgorithm;
public class FractionalSack {
    public static void main(String args[]){
        int[] weight = {10,20,30};
        int[] value  =  {60,100,120};
        int[] ratio = new int[weight.length]  ;
        int capacity = 50;
        for(int i=0;i<weight.length;i++){
            ratio [i] = value[i]/weight[i];
        }
        int ans=0;
        //ratio[] is in assending order
        for(int i=0;i< ratio.length;i++){
            if(capacity>=weight[i]){
                capacity=capacity-weight[i];
                ans=ans+value[i];
            }else{
                ans= ans + ratio[i]*capacity;
                break;
            }
        }
        System.out.println(ans);
    }
}