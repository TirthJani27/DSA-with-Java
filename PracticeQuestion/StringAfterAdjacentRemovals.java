public class StringAfterAdjacentRemovals {
    public static String resultingString(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < sb.length(); i++) {
            int val = (int) sb.charAt(i);
            char lc = (char) (val - 1);
            char rc = (char) (val + 1);
            if (val == 97) {
                lc = 'z';
            }
            if (val == 122) {
                rc = 'a';
            }
            char curr = sb.charAt(i - 1);
            if (curr == lc || curr == rc) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i - 1);
                i -= 2;
                if (i < 0) {
                    i = 0;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hkg";
        System.out.println(resultingString(str));
    }
}
