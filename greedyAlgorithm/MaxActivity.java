package com.dsa.javalearning.greedyAlgorithm;
import java.util.*;
public class MaxActivity {
    public static void main(String args[]){
        int[] start ={1,3,0,5,8,5};
        int[] end ={2,4,6,7,9,9};
        maxActivity(start,end);
    }
    public static void maxActivity(int start[],int end[]){
        //For 0 activity
        int count=0;
        ArrayList<Integer> ans = new ArrayList<>();
        //For 1 activity
        count = 1;
        ans.add(0);
        int lastEnd = end[0];
        for(int i=0;i<end.length;i++){
            if (start[i] >= lastEnd){
                count++;
                lastEnd=end[i];
                ans.add(i);
            }
        }
        for(int i=0;i< ans.size();i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
    }
}