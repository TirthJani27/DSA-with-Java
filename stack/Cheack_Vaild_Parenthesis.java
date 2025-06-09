package stack;
import java.util.*;

public class Cheack_Vaild_Parenthesis {
    public static boolean checkVaildParenthesis(String str){
                Stack<Character> s = new Stack<>();
                int i=0;
                for(i=0;i<str.length();i++){
                    char ch = str.charAt(i);
                    //opeaning
                    if(ch!=')'){
                        s.push(ch);
                    }else{
                        if(s.peek()=='('){
                            s.pop();
                        }else{
                            return false;
                        }
                    }
                }
                if(s.size()==0){
                    return true;
                }else{
                    return false;
                }
            }
    public static void main(String args[]){
        String str="((())";
        System.out.println(checkVaildParenthesis(str));
    }
}
