import java.util.*;
import java.util.stream.Collectors;

public class MinimumDeletionsforAtMostKDistinctCharacters {
    public static int minDeletion(String s, int k) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.putIfAbsent(s.charAt(i), 1);
            }
        }
        LinkedHashMap<Character, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        int i = 0;
        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            if (i == k) {
                break;
            }
            ans += entry.getValue();
            i++;
        }
        System.out.println(ans);
        return s.length() - ans;
    }

    public static void main(String[] args) {
        String s = "yyyzz";
        int k = 1;
        System.out.println(minDeletion(s, k));
    }
}
