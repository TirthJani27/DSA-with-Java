package com.dsa.javalearning.greedyAlgorithm;
import java.util.*;
public class JobSequensingProblem {
    //maximizing the profit
    static class Job{
        int  id;
        int profit;
        int deadLine;

        public Job (int i,int j,int k) {
            id=i;
            profit=k;
            deadLine=j;
        }
    }
    public static void main(String[] args) {
        int jobsInf0[][]={{4,20},{1,10},{1,40},{1,30}};
        Job Jobs[]= new Job[jobsInf0.length];
        ArrayList<Job> list = new ArrayList<>();
        for(int i=0;i< jobsInf0.length;i++){
          list.add(Jobs[i] = new Job(i,jobsInf0[i][0],jobsInf0[i][1]));
        }
        Collections.sort(list,(obj1,obj2) -> obj2.profit-obj1.profit);
        int time=0;
        int totalProfit=0;
        ArrayList<Integer> seq = new ArrayList<>();
        for(int i=0;i< jobsInf0.length;i++){
            Job curr = list.get(i);
            if(curr.deadLine>time){
                seq.add(curr.id);
                time++;
                totalProfit=totalProfit+curr.profit;
            }
        }
        for(int i=0;i< seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
        System.out.println(" ");
        System.out.println(totalProfit);
    }
}
