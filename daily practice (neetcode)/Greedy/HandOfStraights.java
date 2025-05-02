import java.util.Arrays;
import java.util.HashMap;

public class HandOfStraights {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (groupSize == 1) {
            return true;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            int curr = hand[i];
            if (map.get(curr) == 0) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                if (map.containsKey(curr + j) && map.get(curr + j) > 0) {
                    map.replace(curr + j, map.get(curr + j) - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 4, 5 };
        System.out.println(isNStraightHand(arr, 3));
    }
}
