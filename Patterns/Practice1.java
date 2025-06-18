
import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int a = in.nextInt();
        long x = Math.ceilDiv(m,a);
        x*=Math.ceilDiv(n,a);
        System.out.println(x);
    }
}
