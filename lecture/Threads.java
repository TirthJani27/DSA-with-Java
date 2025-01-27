package com.dsa.javalearning.lecture;
import java.util.*;
public class Threads {
    public static void fun(){
        Scanner in = new Scanner(System.in);
        int b = in.nextInt();
        if(b == 0){
            try{
                throw new MyEX();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        System.out.println("Execption is handled" );
    }
    public static void main(String[] args) {
        fun();
    }
}
class MyEX extends Exception{
    @Override
    public String toString() {
        return "I am to String";
    }
    @Override
    public String getMessage(){
        return super.getMessage()+"I am Groot";
    }
}
