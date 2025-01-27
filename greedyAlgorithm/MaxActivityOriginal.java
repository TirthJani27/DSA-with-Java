package com.dsa.javalearning.greedyAlgorithm;
import java.util.*;

public class MaxActivityOriginal {
    static class Pair implements Comparable<Pair>{
        int s,e;
        Pair(int s,int e){
            this.s=s;
            this.e=e;
        }
        public int compareTo(Pair that) {
            return this.e - that.e;
        }
    }
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        ArrayList<Integer> ans = new ArrayList<>();
        Pair[] arrPair = new Pair[N];
        for (int i = 0; i < S.length; i++) {
             arrPair[i]= new Pair(S[i],F[i]);

        }
        Arrays.sort(arrPair);
        for (int i = 0; i < S.length; i++) {
            System.out.println(arrPair[i].s +" " + arrPair[i].e);
        }
        for(int i=1;i<S.length;i++) {
            int prevE = arrPair[i - 1].e;
            int currS = arrPair[i].s;
            if (currS > prevE) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] S={12, 6 ,16, 12, 6 ,9 ,16 ,6, 17, 5};
        int[] F={17 ,13, 16, 18 ,17 ,10 ,18 ,12 ,18 ,11};
        System.out.println(maxMeetings(S.length,S,F));


    }
}
