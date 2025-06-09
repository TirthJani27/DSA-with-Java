package stack;

import java.util.Stack;

public class Check_Dublicate_Parantheses {
    public static boolean checkDublicateParanthesis(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int count=0;
            if(ch!=')'){
                s.push(ch);
            }else{
                while(s.peek()!='('&& !s.isEmpty()){
                    count++;
                    s.pop();
                }if(count>=1){
                    return false;
                }else{
                    s.pop();
                }
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args){
        String str = "((a+b)))";
        System.out.println(checkDublicateParanthesis(str));
    }
}
