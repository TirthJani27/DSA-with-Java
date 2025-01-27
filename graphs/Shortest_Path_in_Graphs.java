package com.dsa.javalearning.graphs;

import java.util.*;

public class Shortest_Path_in_Graphs {
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
            a.get(dest).add(scr);
        }
        int shortestDis(int tar){
            int[] dis = new int[a.size()];
            boolean[]vis = new boolean[a.size()];
            vis[0]=true;
            Arrays.fill(dis,Integer.MAX_VALUE);
            dis[0]=0;
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            while(!q.isEmpty()){
                int curr=q.poll();
                for(int i=0;i<a.get(curr).size();i++){
                    int p = a.get(curr).get(i);
                    if(!vis[p]){
                        vis[p]=true;
                        q.add(p);
                        dis[p]=dis[curr]+1;
                    }
                }
            }
            return dis[tar];
        }
    }

    public static void main(String[] args) {
        Graphs g = new Graphs(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,4);
        g.addEdge(1,3);
        g.addEdge(3,5);
        g.addEdge(2,3);
        g.addEdge(4,5);
        int p = g.shortestDis(3);
        System.out.println(p);
    }
}
