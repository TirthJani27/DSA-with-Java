import java.util.*;
public class GroupAnagrams{
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] checkList = new boolean[strs.length]; 
        for(int i=0;i<strs.length;i++){
            if(!checkList[i]){
                checkList[i] = true;
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                for(int j = i+1;j<strs.length;j++){
                    if(!checkList[i] && isAnagram(strs[i],strs[j])){
                        checkList[i] = true;
                        temp.add(strs[j]);
                    }
                }
            ans.add(temp);
            }
        }

        return ans;
    }
    public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> m1 = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      if (m1.containsKey(s.charAt(i))) {
        m1.put(s.charAt(i), m1.get(s.charAt(i)) + 1);
      } else {
        m1.put(s.charAt(i), 1);
      }
    }
    for (int i = 0; i < s.length(); i++) {
      if (m1.containsKey(t.charAt(i))) {
        if (m1.get(t.charAt(i)) <= 0) {
          return false;
        } else {
          m1.put(t.charAt(i), m1.get(t.charAt(i)) - 1);
        }
      }
      else{
        return false;
      }
    }

    return true;
  }
    public static void main(String args[]){
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(arr));
    }
}