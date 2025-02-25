import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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
        static void bfs(int scr,boolean[] vis){
            Queue<Integer> q=new LinkedList<>();
            q.add(scr);
            vis[scr]=true;
            while(!q.isEmpty()){
                int curr=q.poll();
                System.out.print(curr+" ");
                for (Integer neighbour : a.get(curr)){
                    if(!vis[neighbour]){
                        q.add(neighbour);
                        vis[neighbour] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 11;
        boolean []vis =new boolean[n];
        Graphs g1=new Graphs(n);
        g1.addEdge(0,1);
        g1.addEdge(1,5);
        g1.addEdge(1,2);
        g1.addEdge(2,3);
        g1.addEdge(3,4);
        g1.addEdge(4,5);
        g1.addEdge(5,9);
        g1.addEdge(9,10);
        g1.addEdge(3,6);
        g1.addEdge(6,7);
        g1.addEdge(7,8);
        g1.addEdge(8,6);
        g1.bfs(0,vis);
    }
}
