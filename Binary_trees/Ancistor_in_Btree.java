package com.dsa.javalearning.Binary_trees;

import java.util.ArrayList;

public class Ancistor_in_Btree {
    static class Node{
        int data;
        Node right,left;
        Node(int data){
            this.data=data;
        }
    }
    public static ArrayList<Integer> ancistor(Node root,int key){
        ArrayList<Integer> ans=new ArrayList<>();
        isPresent(root,ans,key);
        return ans;
    }
    public static boolean isPresent(Node root,ArrayList<Integer> ans,int key){
        if(root==null) return false ;
        if(root.data==key) return true ;
        if(isPresent(root.left,ans,key)||isPresent(root.right,ans,key)){
            ans.add(root.data);
            return true;
        }
        return false;
    }
    public static int commonAncistor(Node root,int a,int b){
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> b1=new ArrayList<>();
        isPresent(root,a1,a);
        isPresent(root,b1,b);
        int i=a1.size();
        int j=b1.size();
        while(i>-1 && j>-1){
            if(a1.get(i)==b1.get(j)){
                i--;
                j--;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left = new Node(6);
        System.out.println(ancistor(root,5));
    }
}
