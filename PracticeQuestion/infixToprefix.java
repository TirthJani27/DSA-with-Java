
import java.util.Stack;
public class infixToprefix {
    public static void main(String[] args) {
        String str = " A+(B*C-(D/E*F)*G)*H";
        Stack<Character> stack = new Stack<>();
        stack.push('(');
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                System.out.print(str.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    stack.push(str.charAt(i));
                } else {
                    while (!stack.isEmpty() && prec(str.charAt(i)) <= prec(stack.peek())) {

                            System.out.print(stack.pop());
                    }
                    stack.push(str.charAt(i));
                }
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(' || stack.peek() == ')') {
                System.out.print("");
                stack.pop();
            } else {
                System.out.print(stack.pop());
            }
        }
    }
    public static int prec ( char val){
        if (val == '(') {
            return 4;
        } else if (val == '+' || val == '-') {
            return 1;
        } else if (val == '*' || val == '/') {
            return 2;
        } else if (val == '^' || val == '$') {
            return 3;
        }
        return 0;
    }
}
