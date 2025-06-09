import java.util.*;

public class Subsets {
    public static List<String> subStrings(String s) {
        return fun(s, new StringBuilder(""), 0, new ArrayList<String>());
    }

    public static List<String> fun(String s, StringBuilder sb, int i, List<String> ans) {
        if (i == s.length()) {
            ans.add(sb.toString());
            return ans;
        }
        fun(s, sb, i + 1, ans);

        sb.append(s.charAt(i));
        fun(s, sb, i + 1, ans);
        sb.deleteCharAt(sb.length() - 1); 
        return ans;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(subStrings(s));
    }
}
