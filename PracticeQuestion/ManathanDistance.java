public class ManathanDistance {
    public static int maxDistance(String s, int k) {
        int[] arr = { 0, 0, 0, 0 };
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'N')
                arr[0]++;
            else if (s.charAt(i) == 'S')
                arr[1]++;
            else if (s.charAt(i) == 'W')
                arr[2]++;
            else
                arr[3]++;
        }

        if (k <= arr[1]) {
            arr[1] -= k;
            arr[0] += k;
            k = 0;
        } else if (k <= arr[3]) {
            arr[3] -= k;
            arr[2] += k;
            k = 0;
        } else {
            arr[0] += arr[1];
            arr[2] += arr[3];
            arr[1] = 0;
            arr[3] = 0;

        }

        int max = 0;
        int x = 0;
        int y = 0;
        x += arr[0];
        y += arr[2];
        if (max < Math.abs(x) + Math.abs(y))
            max = Math.abs(x) + Math.abs(y);
        return max;

    }

    public static void main(String[] args) {
        String s = "NEWS";
        System.out.println(maxDistance(s, 1));
    }
}