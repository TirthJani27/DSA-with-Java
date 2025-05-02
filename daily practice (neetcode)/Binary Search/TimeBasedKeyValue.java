import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValue {
    class Pair {
        int val;
        String str;

        Pair(String str, int val) {
            this.str = str;
            this.val = val;
        }
    }

    class TimeMap {

        Map<String, List<Pair>> map;

        public TimeMap() {
            this.map = new LinkedHashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (map.containsKey(key)) {
                List<Pair> tempList = map.get(key);
                tempList.add(new Pair(value, timestamp));
                map.put(key, tempList);
            } else {
                List<Pair> tempList = new ArrayList<>();
                tempList.add(new Pair(value, timestamp));
                map.put(key, tempList);
            }
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }
            List<Pair> curr = map.get(key);
            int l = 0;
            int r = curr.size() - 1;
            int mid = 0;
            while (l <= r) {
                mid = (r + l) / 2;
                if (curr.get(mid).val < timestamp) {
                    l = mid + 1;
                } else if (curr.get(mid).val > timestamp) {
                    r = mid - 1;
                } else {
                    return curr.get(mid).str;
                }
            }
             return curr.get(mid).str;

        }
    }
    public static void main(String[] args) {
        
    }
}
