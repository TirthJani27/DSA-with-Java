package com.dsa.javalearning.graphs;
class Graphs {
    int v;
    static int a[][];
    Graphs(int v){
        this.v=v;
        a=new int[v][v];
    }
    public static void addEdge(int scr,int des){
        a[scr][des]=1;
        a[des][scr]=1;
    }
    static void print(){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v=4;
        Graphs g = new Graphs(v);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.print();
    }
}
