package com.dsa.javalearning.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
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
        static void print() {
            System.out.println(a);
        }
        static void topologicalOrder(){
            boolean[] vis=new boolean[v];
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<v;i++){
                if(!vis[i]){
                    dfs(stack,vis,i);
                }
            }
            while(!stack.isEmpty()){
                System.out.println(stack.pop()+" ");
            }
        }
        static void dfs(Stack<Integer> stack,boolean[] vis,int scr){
            vis[scr]=true;
            for (int neighbour : a.get(scr)) {
                if(!vis[neighbour]){
                    dfs(stack,vis,neighbour);
                }
            }
            stack.add(scr);
        }
    }

    public static void main(String[] args) {
        Graphs g =new Graphs(6);
        g.addEdge(5,0);
        g.addEdge(5,2);
        g.addEdge(2,3);
        g.addEdge(3,1);
        g.addEdge(4,1);
        g.addEdge(4,0);
        g.topologicalOrder();
    }
}
