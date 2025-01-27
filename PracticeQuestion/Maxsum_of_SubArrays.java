package com.dsa.javalearning.PracticeQuestion;

import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class Maxsum_of_SubArrays {
    static void reverse(Stack<Integer> s){
        Queue<Integer> q=new LinkedList<>();
        while(!s.isEmpty()){
            int a=s.pop();
            q.add(a);
        }
        while(!q.isEmpty()){
            s.add(q.remove());
        }
    }
    static ArrayList<Integer> leaders(int arr[], int n) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                ans.add(max);
            }
        }
        Collections.sort(ans, Collections.reverseOrder());
        return ans;
    }
    public static int  Count(int[][] matrix){
        // code here
        int count=0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j]==1){
                    //up left
                    if(i-1<0&&j-1<0){
                        if(matrix[i+1][j]==0){
                            count++;
                        }
                        if(matrix[i+1][j+1]==0){
                            count++;
                        }
                        if(matrix[i][j+1]==0){
                            count++;
                        }
                    }
                    //bottom right
                    else if(i+1>matrix[0].length && j+1>matrix.length){
                        if(matrix[i-1][j-1]==0){
                            count++;
                        }
                        if(matrix[i-1][j]==0){
                            count++;
                        }
                        if(matrix[i][j-1]==0){
                            count++;
                        }
                    }
                    //up right
                    else if(j+1> matrix.length-1 && i-1<0){
                        if(matrix[i+1][j]==0){
                            count++;
                        }
                        if(matrix[i+1][j-1]==0){
                            count++;
                        }
                        if(matrix[i][j-1]==0){
                            count++;
                        }
                    }
                    //bottom left
                    else if(i+1>matrix[0].length && j-1<0){
                        if(matrix[i-1][j]==0){
                            count++;
                        }
                        if(matrix[i][j+1]==0){
                            count++;
                        }
                        if(matrix[i-1][j+1]==0){
                            count++;
                        }
                    }
                    //left
                    else if(i>0 && j==0 ) {
                        if (matrix[i - 1][j] == 0) {
                            count++;
                        }
                        if (matrix[i + 1][j] == 0) {
                            count++;
                        }
                        if (matrix[i][j + 1] == 0) {
                            count++;
                        }
                        if (matrix[i - 1][j + 1] == 0) {
                            count++;
                        }
                        if (matrix[i + 1][j + 1] == 0) {
                            count++;
                        }
                    }
                    //up
                    else if(i-1==0&&j<0) {
                        if (matrix[i][j - 1] == 0) {
                            count++;
                        }
                        if (matrix[i + 1][j + 1] == 0) {
                            count++;
                        }
                        if (matrix[i][j + 1] == 0) {
                            count++;
                        }
                        if (matrix[i + 1][j - 1] == 0) {
                            count++;
                        }
                        if (matrix[i + 1][j] == 0) {
                            count++;
                        }
                    }
                    //right
                    else if(j==matrix.length-1 && i==matrix[0].length-1) {
                        if (matrix[i - 1][j] == 0) {
                            count++;
                        }
                        if (matrix[i + 1][j] == 0) {
                            count++;
                        }
                        if (matrix[i][j - 1] == 0) {
                            count++;
                        }
                        if (matrix[i - 1][j - 1] == 0) {
                            count++;
                        }
                        if (matrix[i + 1][j - 1] == 0) {
                            count++;
                        }
                    }
                    //bottom
                    else if (i==matrix[0].length-1 && j>0){
                        if(matrix[i][j-1]==0){
                            count++;
                        }
                        if(matrix[i][j+1]==0){
                            count++;
                        }
                        if(matrix[i-1][j-1]==0){
                            count++;
                        }
                        if(matrix[i-1][j+1]==0){
                            count++;
                        }
                        if(matrix[i-1][j]==0){
                            count++;
                        }
                    }
                    else{
                        if(matrix[i][j-1]==0){
                            count++;
                        }
                        if(matrix[i][j+1]==0){
                            count++;
                        }
                        if(matrix[i-1][j-1]==0){
                            count++;
                        }
                        if(matrix[i-1][j+1]==0){
                            count++;
                        }
                        if(matrix[i-1][j]==0){
                            count++;
                        }
                        if(matrix[i+1][j+1]==0){
                            count++;
                        }
                        if(matrix[i+1][j-1]==0){
                            count++;
                        }
                        if(matrix[i+1][j+1]==0){
                            count++;
                        }
                    }
                }
            }
        }
        if(count%2==0){
            System.out.println(count);
            return 0;
        }else{
            System.out.println(count);
            return 1;
        }
    }
    static ArrayList<Integer> max_of_subarrays(int a[], int n, int k) {
        // Your code here
        ArrayList<Integer> ans=new ArrayList<>();
        int max=-1;
        for (int i = 0; i < k; i++) {
            if(a[i]>max) {
                max = a[i];
            }
        }
        ans.add(max);
        for (int i = k; i < n; i++) {
            if(a[i]>max){
                max=a[i];
            }
            ans.add(max);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a={0,0,1,1};
        System.out.println(max_of_subarrays(a,a.length,2));
    }
}
