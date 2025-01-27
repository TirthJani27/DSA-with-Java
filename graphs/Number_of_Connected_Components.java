package com.dsa.javalearning.graphs;

import java.util.ArrayList;

public class Number_of_Connected_Components extends GraphsUsingArraylist {
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
            a.get(dest).add(scr);
        }
        static void dfs(int scr ,boolean []vis){
            vis[scr]=true;
            for(Integer neighbour: a.get(scr)){
                if(!vis[neighbour]){
                    dfs(neighbour,vis);
                }
            }
        }
        static int nocc(){
            int counter = 0;
            boolean[] vis = new boolean[v];
            for (int i = 0; i < vis.length;i++) {
                if(!vis[i]){
                    counter++;
                    dfs(i,vis);
                }
            }
            return counter;
        }
    }
    public static void main(String[] args) {
        Graphs g=new Graphs(9);
        g.addEdge(0,3);
        g.addEdge(3,2);
        g.addEdge(2,1);
        g.addEdge(1,4);
        g.addEdge(5,6);
        g.addEdge(6,7);
        g.addEdge(7,5);
        g.addEdge(8,8);
        System.out.println(g.nocc());
    }
}
