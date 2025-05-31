package Theory;
import java.util.Scanner;

public class TryCatchBlock {
    public void main(String[] args) {
        int a = 10000;
        Scanner in = new Scanner(System.in);
        int b = in.nextInt();
        if(b==0){
            try{
                throw new MyEX();
            }catch (Exception e ){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("ENd of the Prep");
    }
}

