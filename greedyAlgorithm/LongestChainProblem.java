package com.dsa.javalearning.greedyAlgorithm;
import java.util.Arrays;
import java.util.Comparator;

public class LongestChainProblem {
    public static void main(String[] args) {
        int[][] chainSize={{5,24},{34,60},{5,28},{27,40},{50,90}};
        System.out.println(maxChainSize(chainSize));
    }
    public static int maxChainSize(int [][] arr) {
        Arrays.sort(arr, Comparator.comparingDouble(o->o[1]));
        int chainlength = 1;
        int chainend = arr[0][1];
        for(int i=0;i< arr.length;i++){
            if(arr[i][0]>chainend){
                ++chainlength;
                chainend=arr[i][1];
            }
        }
        return chainlength;
    }
}
