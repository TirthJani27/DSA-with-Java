import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                int a = Integer.parseInt(tokens[i]);
                s.push(a);
            } catch (NumberFormatException e) {
                int b = s.pop();
                int a = s.pop();
                if (tokens[i].equals("+")) {
                    int c = a + b;
                    s.push(c);
                } else if (tokens[i].equals("-")) {
                    int c = a - b;
                    s.push(c);
                } else if (tokens[i].equals("*")) {
                    int c = a * b;
                    s.push(c);
                } else if (tokens[i].equals("/")) {
                    int c = a / b;
                    // System.out.println(a+" " +b + c +" ");
                    s.push(c);
                }
                // System.out.println(s);
            }
        }
        return s.peek();
    }

    public static void main(String[] args) {
        String[] tokens = { "4", "13", "5", "/", "+" };
        System.out.println(evalRPN(tokens));
    }
}
