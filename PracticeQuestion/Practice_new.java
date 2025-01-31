

import java.util.*;

public class Practice_new {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        hs.add(s.charAt(0));
        int f = 1;
        int ans = 1;
        int b = 0;
        hs.add(s.charAt(b));
        while (f < s.length()) {
            char curr = s.charAt(f);
            if (hs.contains(curr)) {
                hs.remove(s.charAt(b));
                b++;
            } else {
                hs.add(curr);
                f++;
            }
            if (f - b > ans) {
                ans = f - b;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}

