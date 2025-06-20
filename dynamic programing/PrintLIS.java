import java.util.Arrays;

public class PrintLIS {
    public static void printLIS(int[] arr) {
        int n = arr.length;
        int[] pos = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(pos, -1);
        for (int i = 1; i < dp.length; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] > arr[prev] && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    pos[i] = prev;
                }
            }
        }
        int maxi = 0;
        int max = 0;
        int j = 0;
        for (int i : dp) {
            if (i > max) {
                max = i;
                maxi = j;
            }
            j++;
        }

        while (pos[maxi] != -1) {
            System.out.print(arr[maxi] + " ");
            maxi = pos[maxi];
        }
        ;
        System.out.print(arr[maxi]);
        return;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 11, 1, 16, 8 };
        printLIS(arr);
    }
}
