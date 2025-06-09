package stack;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Stack;

public class Reverse_Stack {
    public static void pushBottom(int data,Stack<Integer> s){
        //base
        if(s.size()==0){
            s.push(data);
            return;
        }
        //repetation
        int top=s.pop();
        pushBottom(data,s);
        s.push(top);

    }
    public static void reverseStack(Stack<Integer> s) {
        //base
        if(s.isEmpty()){
            return;
        }
        //repetation
        int top=s.pop();
        reverseStack(s);
        pushBottom(top,s);
    }
    public static void printStack(Stack<Integer> s){
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println("NEW");
        reverseStack(s);
        printStack(s);
    }
}
