
public class ValidParenthesisString {
        public static boolean checkValidString(String s) {
            int low = 0, high = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    low++;
                    high++;
                } else if (c == ')') {
                    if (low > 0)
                        low--;
                    high--;
                } else { 
                    if (low > 0)
                        low--;
                    high++;
                }
                if (high < 0)
                    return false;
            }
            return low == 0;
        }

    public static void main(String[] args) {
        String s = "(((((()*)(*)*))())())(()())())))())))(()())()";
        System.out.println(checkValidString(s));
    }
}