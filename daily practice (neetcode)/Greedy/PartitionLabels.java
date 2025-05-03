import java.util.*;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.replace(c, i);
            }
            map.put(c, i);
        }
        List<Integer> ls = new ArrayList<>();
        int end = 0;
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > end) {
                ls.add(size);
                size = 0;
            }
            end = Math.max(end, map.get(s.charAt(i)));
            size++;
        }
        ls.add(size);
        return ls;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("eccbbbbdec"));
    }
}
