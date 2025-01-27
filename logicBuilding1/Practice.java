package com.dsa.javalearning.logicBuilding1;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n> 0){
            int x = in.nextInt(),y=in.nextInt();
            if(y>=-1)
                System.out.println("YES");
            else
                System.out.println("NO");
            n--;
        }
    }
}
