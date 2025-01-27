package com.dsa.javalearning.lecture;

import java.util.Arrays;

public class JobSequencing {
    static int maxProfit(int[] profits, int[] deadline) {
        int totalProfit = 0;
        int lastday = 0;
        for (int i = 0; i < deadline.length; i++) {
            if (deadline[i] > lastday) {
                lastday = deadline[i];
            }
        }
        int[] days = new int[lastday + 1];
        Arrays.fill(days, -1);
        for (int i = 0; i < profits.length; i++) {
            int lastDayOfJob = deadline[i];
            if (days[lastDayOfJob] == -1) {
                days[lastDayOfJob] = i;
                totalProfit += profits[i];
            } else {
                int j = lastDayOfJob - 1;
                while (j > -1) {
                    if (days[j] == -1 && j > 0) {
                        days[j] = i;
                        totalProfit += profits[i];
                        break;
                    }
                    j--;
                }
            }
        }
        System.out.println("Sequence of Jobs:");
        for (int i = 0; i < days.length; i++) {
//            if (days[i] != -1) {
                System.out.print(days[i] + " ");
//            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] profits = {20 , 15 ,10 , 7, 5,3};
        int[] deadlines = {3,1,1,3,1,3};
        System.out.print("\nmax profit: " + maxProfit(profits, deadlines));
    }
}
