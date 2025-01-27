package com.dsa.javalearning.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectLoopInGraph {
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
        public boolean isCyclic() {
            Queue<Integer> q= new LinkedList<>();
            int[] ind = new int[v];
            int count=0;
            indegree(ind);
            for(int i=0;i<v;i++){
                if(ind[i]==0){
                    count++;
                    q.add(i);
                }
            }
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int i:a.get(curr)){
                    ind[i]--;
                    if(ind[i]==0){
                        count++;
                        q.add(i);
                    }
                }
            }
            if(count<v-1){
                return true;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Graphs g =new Graphs(4);
        g.addEdge(2,0);
        g.addEdge(0,1);
        g.addEdge(1,3);
        g.addEdge(3,1);
        g.addEdge(1,0);
        System.out.println(g.isCyclic());
    }
}
