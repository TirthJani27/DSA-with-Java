
import java.util.Stack;

public class ModiPrac {
    public static void main(String[] args) {
        String a = "{}{}";

    }
    public static boolean utsavBhai (String a){
        for (int i = 0; i < a.length(); i++) {
        }
        return false;
    }
    public static boolean helper(String a, int ind){
        if(ind == a.length()-1){
            return false;
        }
        if(a.charAt(ind) != '$'){
            ind++;
            helper(a,ind);
        }else{
            
        }
//        Temperary
        return  true;
    }
    public static boolean validString(String a){
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == '{'){
                s.add(1);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                s.pop();
            }
        }
        if (!s.isEmpty()){
            return false;
        }
        return true;
    }
}