package com.dsa.javalearning.greedyAlgorithm;
import java.util.*;
public class Cocola_Problem_ {
    public static void main(String[] args) {
        Integer[] horizontalValue = {42,2,11};
        Integer[] verticalValue = {2,1,3,1,4};
        Arrays.sort(horizontalValue,Collections.reverseOrder());
        Arrays.sort(verticalValue,Collections.reverseOrder());
        int h=0,v=0;
        int finalCost=0;
        int hp=1,vp=1;
        while(h<horizontalValue.length && v<verticalValue.length){
            if(horizontalValue[h]>verticalValue[v]){
                finalCost = finalCost+(vp*horizontalValue[h]);
                h++;
                hp++;
            }else{
                finalCost = finalCost+(hp*verticalValue[v]);
                v++;
                vp++;
            }
        }
        while(h< horizontalValue.length){
            finalCost = finalCost+(vp*horizontalValue[h]);
            h++;
            hp++;
        }
        while(v< verticalValue.length){
            finalCost = finalCost+(hp*horizontalValue[v]);
            v++;
            vp++;
        }
        System.out.println("The Minimum cost to cut the chocolate bar is =" +finalCost);
    }
}
