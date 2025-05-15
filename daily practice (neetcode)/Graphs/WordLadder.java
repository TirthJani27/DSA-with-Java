import java.util.*;

public class WordLadder {
    public static class Pair {
        String str;
        int level;

        Pair(String str, int level) {
            this.str = str;
            this.level = level;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 0;
        Queue<Pair> q = new ArrayDeque<>();
        HashSet<String> hs = new HashSet<>();
        for (String string : wordList) {
            hs.add(string);
        }
        if (!hs.contains(endWord)) {
            return 0;
        }
        q.add(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            String currS = curr.str;
            int level = curr.level;
            StringBuilder temp = new StringBuilder(currS);
            for (int i = 0; i < temp.length(); i++) {
                for (int j = 97; j <= 122; j++) {
                    temp.setCharAt(i, (char) j);
                    if (temp.toString().equals(endWord)) {
                        return level + 1;
                    }
                    if (hs.contains(temp.toString())) {
                        q.add(new Pair(temp.toString(), level + 1));
                        hs.remove(temp.toString());
                    }
                }
                temp = new StringBuilder(currS);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength("hit", "cog", wordList));
    }
}
