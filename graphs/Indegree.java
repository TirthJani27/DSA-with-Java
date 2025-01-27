package com.dsa.javalearning.graphs;
import java.util.*;
public class Indegree {
    static class Graphs {
        static ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        int v;

        Graphs(int v) {
            this.v = v;
            for (int i = 0; i < v; i++) {
                a.add(new ArrayList<>());
            }
        }
        static void addEdge(int scr, int dest) {
            a.get(scr).add(dest);
        }
        static void indegree(int[] indegre){
            for (ArrayList<Integer> adjacent :a){
                for (Integer neighbour: adjacent) {
                    indegre[neighbour]++;
                }
            }
        }
    }
    public static void main(String[] args) {
        Graphs g =new Graphs(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        int ind[] = new int[4];
        g.indegree(ind);
        for (int i: ind) {
            System.out.println(ind[i]);
        }
    }
}
