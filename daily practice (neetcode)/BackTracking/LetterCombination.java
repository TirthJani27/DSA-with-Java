import java.util.ArrayList;
import java.util.List;

class LetterCombination {
    static String[] helper = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        dfs(0, digits, ans, new StringBuilder());
        return ans;
    }

    public static void dfs(int index, String digits, List<String> ans, StringBuilder temp) {
        if (index == digits.length()) {
            ans.add(temp.toString());
            return;
        }
        String s = helper[(int) digits.charAt(index) - 48];
        for (int i = 0; i < s.length(); i++) {
            temp.append(s.charAt(i));
            dfs(index + 1, digits, ans, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("235"));
    }
}