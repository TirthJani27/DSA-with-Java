import java.util.*;

class PermutationOfOneInAnother{
    public static void main(String args[]){
        String str1 = "avf";
        String str2 = "bcaaavddd";
        System.out.println(checkInclusion(str1,str2));
    }
    public static boolean checkInclusion(String str1,String str2){
        Map<Character,Integer> map1 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if(map1.containsKey(str1.charAt(i))){
                map1.put(str1.charAt(i), map1.get(str1.charAt(i))+1);
            }
            map1.put(str1.charAt(i), 1);
        }
        for (int i = 0; i < str2.length(); i++) {
            if(map1.containsKey(str2.charAt(i))){
                
            }
        }
        return true;
    }
}