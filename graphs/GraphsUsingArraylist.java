package com.dsa.javalearning.graphs;
import java.util.ArrayList;
public class GraphsUsingArraylist {
    static class Graphs{
        static ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        int v;
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
        static void print() {
            System.out.println(a);
        }
        static void dfs(int scr ,boolean []vis){
            vis[scr]=true;
            System.out.print(scr+" ");
            for(Integer neighbour: a.get(scr)){
                if(!vis[neighbour]){
                    dfs(neighbour,vis);
                }
            }
        }

    }
    public static void main(String[] args) {
        Graphs g=new Graphs(4);
        g.addEdge(0,3);
        g.addEdge(3,2);
        g.addEdge(2,1);
        g.addEdge(1,0);
        g.print();
        boolean[] vis = new boolean[4];
        g.dfs(0,vis);
    }
}
