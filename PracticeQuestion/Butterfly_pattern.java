package com.dsa.javalearning.PracticeQuestion;
import java.util.*;

public class Butterfly_pattern{
    static class Account{
        int amount;
        String name;
        Account(int amount , String name){
            this.amount = amount;
            this.name = name;
        }
        public void doPayment(Account p2){
            Scanner in = new Scanner(System.in);
            int ran = (int)(Math.random()*1000000) % 10000000;
//            System.out.println(171424);
            String capcha = capcha(ran);
            System.out.println("Capche: "+capcha);
            System.out.println("Please enter valid capche: ");
            String respond = in.next();
            if(!capcha.equals(respond)){
                System.out.println("           *** Invalid Capche ***");
                System.out.println("Payment Successful");
                return;
            }
            System.out.println("Enter the amount to be paid to " +p2.name+ ":");
            int temp= in.nextInt();
            if(temp>this.amount){
                System.out.println("   **** Invalid Amount ****");
                return;
            }
            this.amount-=temp;
            p2.amount+=temp;
            System.out.println("Payment Successful");
        }
    }
    static String capcha(int num){
        StringBuilder sb = new StringBuilder();
        while(num>0){
            int temp = num%10;
            if(temp == 0){
                sb.append('s');
            } else if (temp==1) {
                sb.append('k');
            }
            else if (temp==2) {
                sb.append('o');
            }
            else if (temp==3) {
                sb.append('w');
            }
            else if (temp==4) {
                sb.append('t');
            }
            else if (temp==5) {
                sb.append('c');
            }
            else if (temp==6) {
                sb.append('p');
            }else if (temp==7) {
                sb.append('q');
            }else if (temp==8) {
                sb.append('x');
            }else if (temp==9) {
                sb.append('b');
            }
            num/=10;
        }
        return sb.toString();
    }
    public static void main(String args[]){
        Account p1 = new Account(1000,"Chagan Bhai");
        Account p2 = new Account(100,"Magan Bhai");
        p1.doPayment(p2);
    }
}