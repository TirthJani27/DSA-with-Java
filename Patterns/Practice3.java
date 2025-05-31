package Patterns;
public class Practice3 {
    public static void main(String[] args) {
        int rows = 5;
        for(int i=0;i<rows-1;i++){
            for (int j = rows - i; j > 0; j--) {
                System.out.print(" ");
            }
            int k=0;
            while (k<=i){
                System.out.print("* ");
                k++;
            }
            System.out.println();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(" ");
            }
            int k = 0;
            while (k<rows-i){
                System.out.print("* ");
                k++;
            }
            System.out.println();
        }
        System.out.println("--------------------------------------");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < rows-1; i++) {
            for (int j = rows-i-1; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------");
        for (int i = 0; i < rows; i++) {
            for (int j = rows-i-1; j>0 ; j--) {
                System.out.print(" ");
            }
            int k = 0;
            while(k < (2*i)+1){
                System.out.print("* ");
                k++;
            }
            System.out.println();
        }
        System.out.println("--------------------------------------");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows-i; j++) {
                System.out.print(" ");
            }
            int k=0;
            int a = (i*2)+1;
            while(k<(i*2)+1){
                System.out.print( a);
                a--;
                k++;
            }
            System.out.println();
        }
    }
}
