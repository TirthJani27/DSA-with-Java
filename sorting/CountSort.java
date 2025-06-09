package sorting;
public class CountSort {
    public static void main(String[] args) {

        int[] arr = {1, 8, 9, 1, 5, 2, 3};
        countSort(arr);
        printArr(arr);
    }

    public static void countSort(int[] arr) {
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                count[i]--;
                j++;
            }
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


