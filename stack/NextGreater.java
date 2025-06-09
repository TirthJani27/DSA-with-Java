package stack;

import java.util.Stack;

//BruteForce code
public class NextGreater {
    public static void main(String args[]){
        int arr[]={1,5,2,4,6};
        int isGreat[]=new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while( !s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                isGreat[i]=-1;
            }else{
                isGreat[i]=arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0;i< arr.length;i++){
            System.out.print(isGreat[i]+" ");
        }
    }
}
