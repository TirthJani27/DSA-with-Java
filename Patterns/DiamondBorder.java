package Patterns;

public class DiamondBorder {
    public static void printDiamond(int n) {
        for (int i = 0; i < n * 2 - 1; i++) {
            if (i < n) {
                for (int j = 0; j < n + i; j++) {
                    if (n + i - 1 == j) {
                        System.out.print("*");
                    } else if (n - i - 1 == j) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            } else {
                for (int j = 0; j < n * 2 - 1; j++) {
                    if (j == i - n + 1 || j == n * 3 - i - 3) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int n = 24;
        printDiamond(n);
    }
}