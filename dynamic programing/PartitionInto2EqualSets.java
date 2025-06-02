public class PartitionInto2EqualSets {
    public static boolean partitionSubSet(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return canPartition(arr, arr.length, sum / 2);
    }

    // Helper function to check if there's a subset with sum equal to target
    public static boolean canPartition(int[] arr, int n, int target) {
        if (target == 0) {
            return true;
        }
        if (n == 0 || target < 0) {
            return false;
        }
        // Include or exclude the current element
        return canPartition(arr, n - 1, target) || canPartition(arr, n - 1, target - arr[n - 1]);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(partitionSubSet(arr));
    }
}