package com.dsa.javalearning.jailPractice;

public class StockBuySellOneTime {
    public static int maxPrices(int[] arr) {
        int profit = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int j = i + 1;

//            System.out.println("i " + arr[i]);
            while (arr[j] > arr[i]) {
                j++;
            }
            if (profit < arr[j - 1] - arr[i]) {
                profit = arr[j - 1] - arr[i];
            }
            System.out.println(profit);
            i = j+1;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
//        maxPrices(stockPrices);
        System.out.println(maxPrices(stockPrices));
    }
}
