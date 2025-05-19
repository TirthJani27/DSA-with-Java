import java.util.*;

class WordPatter {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        String[] words = s.split(" ");

        if (words.length == pattern.length()) {
            for (int i = 0; i < words.length; i++) {
                char currC = pattern.charAt(i);
                String currS = words[i];
                map.putIfAbsent(currC, currS);
                map2.putIfAbsent(currS, currC);
                if (!map.get(currC).equals(currS) || map2.get(currS) != currC) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abba";
        String s2 = "dog dog dog dog";
        System.out.println(wordPattern(s1, s2));
    }
}