import java.util.ArrayList;
import java.util.List;

public class GenerateValidParenthesis {
    static List<String> ans = new ArrayList<>();

    public static void generateString(StringBuilder s, int n, int open, int close) {
        if (open == n && close == n) {
            ans.add(s.toString());
            return;
        }
        if (open > close) {
            s.append(")");
            generateString(s, n, open, close + 1);
            s.setLength(s.length() - 1);

        }
        if (open < n) {
            s.append("(");
            generateString(s, n, open + 1, close);
            s.setLength(s.length() - 1);

        }
    }

    public static List<String> generateParenthesis(int n) {
        StringBuilder s = new StringBuilder("(");
        generateString(s, n, 1, 0);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }
}