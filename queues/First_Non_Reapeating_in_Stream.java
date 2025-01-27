package com.dsa.javalearning.queues;
import java.util.LinkedList;
import java.util.Queue;
/*
    a  -> a
    aa -> -1
    aab -> b
    aabc -> b (First non repeating)
    aabcc -> b
    aabccx -> b
    aabccxb -> x
*/
public class First_Non_Reapeating_in_Stream {
    public static void firstNonRepeating(String str){
        Queue<Character> q = new LinkedList<>();
        int frequency[] = new int[26];
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            frequency[ch-'a'] = frequency[ch-'a']+1;
            while (!q.isEmpty() &&   frequency[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print("-1 ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
    }
    public static void main(String args[]){
        String str="aabccxb";
        firstNonRepeating(str);
    }
}