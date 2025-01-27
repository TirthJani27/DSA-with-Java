package com.dsa.javalearning.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class Countdistinctelementsineverywindow {
    static ArrayList<Integer> countDistinct(int a[], int n, int k)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map =new HashMap<>();
//        for(int i=0;i<n;i++){
////            if(i%k==0 && i!=0){
////                ans.add(map.size());
////                map.remove(a[i-k]);
////            }
//            if(map.containsKey(a[i])){
//                int val=map.get(a[i])+1;
//                map.replace(a[i],val);
//            }else{
//                map.put(a[i],0);
//            }
//        }
//        ans.add(map.size());
        int i=0;
        for (i = 0; i < k; i++) {
            if(map.containsKey(a[i])){
                int val=map.get(a[i])+1;
                map.replace(a[i],val);
            }else{
                map.put(a[i],0);
            }
        }
        ans.add(map.size());
        while (i<n) {
            if(map.get(a[i-k])==0){
                map.remove(a[i-k]);
            }else{
                map.replace(a[i-k],map.get(a[i-k])-1);
            }
            if(map.containsKey(a[i])){
                int val=map.get(a[i])+1;
                map.replace(a[i],val);
            }else{
                map.put(a[i],0);
            }
            ans.add(map.size());
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a={1,2,1,3,4,2,3};
        System.out.println(countDistinct(a,a.length,4));
    }
}
