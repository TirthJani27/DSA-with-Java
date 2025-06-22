public class DivideString {
    public static String[] divideString(String s, int k, char fill) {
        int j = 0;
        int len = 0;
        if (s.length() % k == 0)
            len = s.length() / k;
        else
            len = s.length() / k + 1;
        String[] res = new String[len];
        StringBuilder curr = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && i % k == 0) {
                res[j] = curr.toString();
                j++;
                curr = new StringBuilder("");
            }
            curr.append(s.charAt(i));
        }
        while (curr.length() % k != 0) {
            curr.append(fill);
        }
        res[j] = curr.toString();
        return res;
    }

    public static void main(String[] args) {
        String s = "abcdefghi";
        int k = 3;
        char fill = 'x';
        String[] res = divideString(s, k, fill);
        for (String str : res) {
            System.out.println(str);
        }
    }
}