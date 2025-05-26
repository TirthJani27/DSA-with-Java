public class Fibo {
    public static int fibo(int n, int[] arr) {
        if (n <= 1) {
            return n;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = fibo(n - 1, arr) + fibo(n - 2, arr);
        return arr[n];
    }

    public static void fun(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(fibo(n, dp));

    }

    public static void main(String[] args) {
        int n = 15;
        fun(n);
    }
}
