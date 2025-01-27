package com.dsa.javalearning.Binary_trees;
import java.util.LinkedList;
import java.util.*;
import java.util.Scanner;
public class Making_A_BTree {
    Node root;
    static Scanner in=new Scanner(System.in);
    static class Node{
        int data;
        Node left,right;
        Node(int data){ this.data=data; }
    }
    static Node creatingBT(){
        System.out.println("Enter the data of Node:");
        int data= in.nextInt();
        if(data == -1) return null;
        Node newNode=new Node(data);
        System.out.println("Enter the data of "+newNode.data+"'s left Node");
        newNode.left=creatingBT();
        System.out.println("Enter the data of "+newNode.data+"'s right Node");
        newNode.right=creatingBT();
        return newNode;
    }
    static void inOrderTravel(Node root){
        if(root==null) return;
        inOrderTravel(root.left);
        System.out.println(root.data);
        inOrderTravel(root.right);
    }
    static void preOreder(Node root){
        if(root == null) return;
        System.out.println(root.data);
        preOreder(root.left);
        preOreder(root.right);
    }
    static int height(Node root){
        if(root==null) return 0;
        int hl=height(root.left);
        int hr=height(root.right);
        int h=Math.max(hl,hr)+1;
        return h;
    }
    static void Kthdistace(Node root,int k){
        if(root==null)return ;
        if(k==0) {
            System.out.println(root.data);
            return;
        }
        Kthdistace(root.left,k-1);
        Kthdistace(root.right,k-1);
    }
    static int min=0;
    static void min(Node root){
        if(root==null){
            return ;
        }
        if(root.data>min){
            min=root.data;
        }
        min(root.left);
        min(root.right);
    }
    static int ans=0;
     static int diameter(Node root) {
        // Your code here
         if(root==null){
             return 0;
         }
         int rh=diameter(root.right);
         int lh=diameter(root.left);
         ans=Math.max(ans,Math.max(rh,lh)+1);
         return ans;
     }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(7);
        root.left.right=new Node(3);
        root.left.left=new Node(4);
        root.right.right=new Node(5);
        root.right.left=new Node(6);
//        inOrderTravel(root);
//        preOreder(root);
//        System.out.println(height(root));
//        min(root);
//        System.out.println(min);
        System.out.println(diameter(root));
    }
}
