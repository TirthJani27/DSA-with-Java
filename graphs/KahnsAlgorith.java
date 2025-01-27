package com.dsa.javalearning.graphs;

import java.util.*;
import java.util.zip.InflaterInputStream;

public class KahnsAlgorith {
    static class Graphs{
        static ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        static int v;
        Graphs(int v){
            this.v=v;
            for(int i=0;i<v;i++){
                a.add(new ArrayList<>());
            }
        }
        static void addEdge(int scr,int dest){
            a.get(scr).add(dest);
        }
        static void print() {
            System.out.println(a);
        }
        static void indegree(int[] indegree){
            for (ArrayList<Integer> adjacent :a){
                for (Integer neighbour: adjacent) {
                    indegree[neighbour]++;
                }
            }
        }
        static void kahnsAlgo(int[] ind){
            Queue<Integer> q = new LinkedList<>();
            boolean vis[] = new boolean[v];
            for(int i=0;i<v;i++) {
                if (ind[i] == 0) {
                    vis[i] = true;
                    q.add(i);
                }
            }
            while(!q.isEmpty()){
                int curr = q.poll();
                System.out.print(curr+" ");
                for (int p: a.get(curr)) {
                    ind[p]--;
                    if(ind[p]==0){
                        q.add(p);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Graphs g =new Graphs(6);
        g.addEdge(4,0);
        g.addEdge(5,0);
        g.addEdge(5,2);
        g.addEdge(2,3);
        g.addEdge(3,1);
        g.addEdge(4,1);
        int arr []= new int[6];
        g.indegree(arr);
        g.kahnsAlgo(arr);

    }
}
