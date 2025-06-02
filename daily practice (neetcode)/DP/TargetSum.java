public class TargetSum {
    public static int findTargetSumWays(int[] arr, int tar) {
        return fun(arr, tar, arr.length - 1);
    }

    public static int fun(int[] arr, int tar, int i) {
        if (i == 0) {
            int count = 0;
            if (tar == arr[0])
                count++;
            if (tar == -arr[0])
                count++;
            return count;
        }
        int min = fun(arr, tar - arr[i], i - 1);
        int add = fun(arr, tar + arr[i], i - 1);
        return min + add;
    }

    public static void main(String[] args) {
        
    }
}
