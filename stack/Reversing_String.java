package stack;

import java.util.Stack;
public class Reversing_String {
    //using collection framework
    public static String reversSting(String str){
        Stack<Character> s = new Stack<>();
        int idx=0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder strr= new StringBuilder();
        while(!s.isEmpty()) {
            char top = s.pop();
            strr.append(top);
        }
        return strr.toString();
    }

    public static void main(String args[]){
        String str= "RACECAR";

        System.out.println(reversSting(str));

    }
}
