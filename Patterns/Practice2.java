package Patterns;
public class Practice2 {
    public static void main(String[] args) {
        int rows = 5;
        System.out.print(" ");
        for (int i = 0; i < rows; i++) {
            int k=0;
            for (int j = rows-i ; j > 0 ; j--) {
                System.out.print(" ");
            }
            while(k<(i*2)+1){
                System.out.print("* ");
                k++;
            }
            System.out.println();
        }
    }
}
