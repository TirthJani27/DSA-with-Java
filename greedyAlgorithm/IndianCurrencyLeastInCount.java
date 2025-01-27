package com.dsa.javalearning.greedyAlgorithm;
import java.util.ArrayList;
public class IndianCurrencyLeastInCount {
    public static void main(String[] args) {
        int curr[]={500,100,50,20,10,5,2,1};
        int val=20200;
        leastNumberofCurrency(curr,val);
    }
    public static void leastNumberofCurrency(int curr[],int val) {
        ArrayList<Integer> list =new ArrayList<>();
        int number = 0;
        for(int i=0;i<curr.length;i++){
            while(val>=curr[i]){
                number++;
                val=val-curr[i];
                list.add(curr[i]);
            }
        }
        System.out.println(number+" ");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
