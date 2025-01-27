package com.dsa.javalearning.PracticeQuestion;

import com.dsa.javalearning.heaps.HeapSort;

import java.util.*;

public class Prac {
    public static void main(String[] args) {

    }
    public static int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int idx = 0;
        int currArrIdx = 0;
        int arrIdx = -1;
        for(List<Integer> l : arrays){
            for(int val : l){
                if(min>val){
                    min = val;
                    arrIdx = idx;
                }
                break;
            }
            idx++;
        }
        for(List<Integer> l : arrays){
            int len = l.size();
            idx = 0;
            for(int val : l){
                if(currArrIdx == arrIdx){
                    break;
                }
                if(idx == len-1){
                    if(val > max){
                        max = val;
                    }
                }
                idx++;
            }
            currArrIdx++;
        }
        return Math.abs(max-min);
    }
}