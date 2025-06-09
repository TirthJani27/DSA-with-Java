package sorting;
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 18, 19, 10, 5, 6322, 63};
        selectionSort(arr);
        printArr(arr);
    }

    public static void selectionSort(int[] arr) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = Integer.MAX_VALUE;
            minIndex = -1;
            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[minIndex];
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
