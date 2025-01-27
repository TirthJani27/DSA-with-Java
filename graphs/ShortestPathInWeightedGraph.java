package com.dsa.javalearning.graphs;

import java.util.*;

public class ShortestPathInWeightedGraph {
    static class Pair{
        int v;
        int wt;
        Pair(int v,int wt){
            this.v=v;
            this.wt=wt;
        }
    }
    static class Graphs {
        static int V;
        static ArrayList<ArrayList<Pair>> a  = new ArrayList<>();
        Graphs(int v) {
            this.V=v;
            for (int i = 0; i < V; i++) {
                a.add(new ArrayList<Pair>());
            }
            int[] indeg = new int[V];
        }
        public static void addEdge(int src,int des,int wt){
            a.get(src).add(new Pair(des,wt));
        }
        static void dfs(Stack<Integer> stack,boolean[] vis,int scr){
            vis[scr]=true;
            for (Pair neighbour : a.get(scr)) {
                if(!vis[neighbour.v]){
                    dfs(stack,vis,neighbour.v);
                }
            }
            stack.push(scr);
        }
        static Stack topologicalOrder(){
            boolean[] vis=new boolean[V];
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<V;i++){
                if(!vis[i]){
                    dfs(stack,vis,i);
                }
            }
            return stack;
        }
        static int[] ShortestPathWithWeight(int scr){
            Stack <Integer> stack=topologicalOrder();
            int[] minDis = new int[V];
            int[] topo = new int[V];
            int i=0;
            while(!stack.isEmpty()){
                int curr = stack.pop();
                topo[i]=curr;
                i++;
            }
            Arrays.fill(minDis,Integer.MAX_VALUE);
            minDis[scr]=0;
            for(int u : topo){
                for(Pair neighbour : a.get(u)){
                    if(minDis[neighbour.v] > minDis[u] + neighbour.wt){
                        minDis[neighbour.v]=minDis[u] + neighbour.wt;
                    }
                }
            }
            return minDis;
        }
    }
    public static void main(String[] args) {
        Graphs g =new Graphs(5);
        g.addEdge(0,1,2);
        g.addEdge(0,2,1);
        g.addEdge(0,4,7);
        g.addEdge(1,4,4);
        g.addEdge(2,3,2);
        g.addEdge(3,4,2);
        int arr[] = new int[4];
        arr = g.ShortestPathWithWeight(0);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
