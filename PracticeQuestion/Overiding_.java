
import java.util.*;
public class Overiding_ {
    public static ArrayList<Integer> duplicates(int[] a, int n) {
        Map<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer> nulll=new ArrayList<>();
        nulll.add(-1);
        for(int i=0;i<a.length;i++){
            if(!hm.containsKey(a[i])){
                hm.put(a[i],1);
            }else{
                int val=hm.get(a[1]);
                val++;
                hm.put(a[i],val);
            }
        }
        for (Map.Entry<Integer, Integer> set : hm.entrySet()) {
            int k=set.getValue();
            if(k>1){
                ans.add(set.getKey());
            }
        }
        if(ans.isEmpty()){
            return nulll;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a={2,3,1,2,3};
        System.out.println(duplicates(a, a.length));
    }
}